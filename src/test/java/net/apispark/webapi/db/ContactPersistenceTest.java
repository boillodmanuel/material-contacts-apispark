package net.apispark.webapi.db;

import org.junit.Assert;
import org.junit.Test;
import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;

import javax.swing.plaf.metal.MetalIconFactory;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * Created by vannasay on 26/10/16.
 */
public class ContactPersistenceTest {

    @Test
    public void test1(){
        Contact contact = new Contact();
        Assert.assertThat(ContactPersistence.INSTANCE.addContact(contact).getId(), is(instanceOf(String.class)));
    }

    @Test
    public void test2(){
        Contact contact = new Contact("3713", "Vannasay", "Souvannavong", "svg-1", "male");
        ContactPersistence.INSTANCE.addContact(contact);
        Assert.assertEquals(ContactPersistence.INSTANCE.getContact("3713"), contact);
    }
}
