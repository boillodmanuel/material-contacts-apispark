package net.apispark.webapi.db;

import net.apispark.webapi.representation.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactPersistenceTest {

    @Test
    public void assignIdToContactIfNull() throws Exception {
        ContactPersistence contactPersistence = ContactPersistence.INSTANCE;
        Contact contact = new Contact(null, "testFirstName", "testLastName", null);
        Contact result = contactPersistence.addContact(contact);
        Assert.assertNotNull(result.getId());
        Assert.assertEquals(result.getFirstName() + " " + result.getLastName(), "testFirstName testLastName");
    }

    @Test
    public void requestContactById() throws Exception {
        ContactPersistence contactPersistence = ContactPersistence.INSTANCE;
        Contact contact = new Contact("testId", "testFirstName", "testLastName", null);
        contactPersistence.addContact(contact);
        Assert.assertEquals(contactPersistence.getContact("testId"), contact);
    }

}
