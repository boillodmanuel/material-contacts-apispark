package net.apispark.webapi;

import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public class ContactPersistenceTest {
	
	@Test
	public void test1() throws Exception {
		Contact c = ContactPersistence.INSTANCE.addContact(new Contact()) ;
        Assert.assertThat(c, is(instanceOf(Contact.class)));
        Assert.assertNotNull(c.getId());
    }
	
	@Test
	public void test2() throws Exception {
		Contact c = ContactPersistence.INSTANCE.addContact(new Contact()) ;
		Contact c2 = ContactPersistence.INSTANCE.getContact(c.getId()) ;
        Assert.assertEquals(c, c2);
    }
}
