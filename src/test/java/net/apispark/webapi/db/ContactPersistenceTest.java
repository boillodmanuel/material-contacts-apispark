package net.apispark.webapi.db;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;

import net.apispark.webapi.representation.Contact;

public class ContactPersistenceTest {
	@Test
	public void TestId() throws Exception {
		Contact contact= new Contact();
		contact.setFirstName("mat");
		Contact contactSaved = ContactPersistence.INSTANCE.addContact(contact); 
		Assert.assertThat(contactSaved, is(notNullValue()));
  
    }
	@Test
	public void TestIdBis() throws Exception {
		Contact contact= new Contact();
		contact.setFirstName("mat");
		Contact contactSaved = ContactPersistence.INSTANCE.addContact(contact);
		Contact contactRecup = ContactPersistence.INSTANCE.getContact(contactSaved.getId());
		Assert.assertThat(contactRecup.getId(), is(contactSaved.getId()));
    }
	
}
