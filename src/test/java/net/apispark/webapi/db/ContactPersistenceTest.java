package net.apispark.webapi.db;

import net.apispark.webapi.representation.Contact;
import org.junit.Assert;
import org.junit.Test;
public class ContactPersistenceTest {



    @Test
    public void adding_new_contact_return_contact_with_id(){
        Contact contact = new Contact();
        ContactPersistence.INSTANCE.addContact(contact);
        Assert.assertNotEquals(contact.getId(), null);
    }


    @Test
    public void adding_new_contact_then_request_by_id_return_same_contact(){
        Contact contact = new Contact();
        ContactPersistence.INSTANCE.addContact(contact);
        String s = contact.getId();
        Contact requested = ContactPersistence.INSTANCE.getContact(s);
        Assert.assertEquals(contact, null);
    }


}
