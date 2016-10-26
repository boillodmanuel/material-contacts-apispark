package net.apispark.webapi.db;

import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.is;
import net.apispark.webapi.representation.Contact;

public class ContactPersistenceTest {

	@Test
	public void addContact() throws Exception {
		Contact myContact = ContactPersistence.INSTANCE.addContact(new Contact(
				"1", "Nicolas", "Dutronc", "svg-5"));
		Assert.assertNotNull(myContact.getId());
	}

	@Test
	public void returnContact() throws Exception {
		Contact myContact = ContactPersistence.INSTANCE.addContact(new Contact(
				"5", "Nicolas", "Dutronc", "svg-5"));
		Contact retrieve = ContactPersistence.INSTANCE.getContact(myContact
				.getId());
		Assert.assertThat(myContact.getId(), is(retrieve.getId()));
	}

}
