package net.apispark.webapi;

import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Manuel Boillod
 */
public class DummyTest {
    
    @Test
    public void dummy_assertion() throws Exception {
        Assert.assertThat("test is good", is(instanceOf(String.class)));
    }
    @Test
    public void addContactTest1() throws Exception {
        Contact exemple = new Contact();
        ContactPersistence.INSTANCE.addContact(exemple);
        Assert.assertNotEquals(null, exemple.getId());
    }


    @Test
    public void addContactTest2() throws Exception{
        Contact exemple = new Contact();
        ContactPersistence.INSTANCE.addContact(exemple);
        Assert.assertEquals(exemple, ContactPersistence.INSTANCE.getContact(exemple.getId()));
    }
}
