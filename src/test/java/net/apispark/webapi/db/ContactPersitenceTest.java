package net.apispark.webapi.db;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;

import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;

public class ContactPersitenceTest {

	/**
	 * Adding a new contact should return the created contact
	 * 		with an assigned id
	 * 
	 * @throws Exception
	 */
	@Test
	public void contact_creation_should_assign_id() throws Exception {
		Contact contact = new Contact(null, "First name", "Last name", null, null);
		ContactPersistence.INSTANCE.addContact(contact);
		Assert.assertThat(contact.getId(), is(not(nullValue())));
	}
	
	/**
	 * Adding a new contact then requesting it by id
	 * 		should return the contact
	 * 
	 * @throws Exception
	 */
	@Test
	public void requesting_contact_id_should_return_contact() throws Exception {
		Contact contact = new Contact(null, "First name", "Last name", null, null);
		String id = ContactPersistence.INSTANCE.addContact(contact).getId();
		Assert.assertThat(contact, is(ContactPersistence.INSTANCE.getContact(id)));
	}
}
