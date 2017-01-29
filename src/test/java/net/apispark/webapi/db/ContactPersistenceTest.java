package net.apispark.webapi.db;

import net.apispark.webapi.representation.Contact;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by sebastian on 26/10/2016.
 */
public class ContactPersistenceTest {

    @Test
    public void added_contact_is_correct() {
        Contact newContact = new Contact(null, "Sebastian", "Sierra", "svg-1", "Male");
        Contact result = ContactPersistence.INSTANCE.addContact(newContact);
        Assert.assertNotNull(result.getId());
    }

    @Test
    public void added_contact_is_retreived_by_id() {
        Contact newContact = new Contact(null, "Sebastian", "Sierra", "svg-1", "Male");
        Contact result = ContactPersistence.INSTANCE.addContact(newContact);
        Contact retreived = ContactPersistence.INSTANCE.getContact(result.getId());
        Assert.assertThat(result.getId(), is(retreived.getId()));
    }

}
