package net.apispark.webapi.db;

import org.junit.Assert;
import org.junit.Test;
import net.apispark.webapi.representation.Contact;

public class ContactPersistenceTest {
	@Test
	public void addContactTest() throws Exception {
		Contact exemple = new Contact();
		ContactPersistence.INSTANCE.addContact(exemple);
		Assert.assertNotEquals(null, exemple.getId());
	}

	@Test
	public void getContactTest() throws Exception {
		Contact exemple = new Contact();
		ContactPersistence.INSTANCE.addContact(exemple);
		Assert.assertEquals(exemple, ContactPersistence.INSTANCE.getContact(exemple.getId()));
	}
	@Test
	public void getContactTest2() throws Exception {
		Contact exemple = new Contact();
		ContactPersistence.INSTANCE.addContact(exemple);
		Assert.assertEquals(1, 2);
	}
	
	// switch to travis
}
