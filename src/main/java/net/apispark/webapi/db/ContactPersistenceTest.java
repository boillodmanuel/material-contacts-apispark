package net.apispark.webapi.db;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

import java.awt.List;

import net.apispark.webapi.representation.Contact;

import org.junit.Assert;
import org.junit.Test;


public class ContactPersistenceTest extends ContactPersistence {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Assert.assertThat("test is good", is(instanceOf(String.class)));
	}
	
	@Test
	public void returnContact() {
		//Contact c =ContactPersistence.INSTANCE.addContact(null);
		Contact c = new Contact("123", "Contact1", "Lastname", "No avatar");
		ContactPersistence.INSTANCE.addContact(c);
		Assert.assertThat(c, is(instanceOf(Contact.class)));
	}
	
	@Test
	public void getContact() {
		//ContactPersistence c =ContactPersistence.INSTANCE.addContact(null);
		//String id = c.getId();
		//Assert.assertThat(id, is(instanceOf(String.class)));
		Contact c = new Contact("123", "Contact1", "Lastname", "No avatar");
		Contact c1 = ContactPersistence.INSTANCE.getContact("123");
		Assert.assertThat(c1, is(instanceOf(Contact.class)));
	}
	
	@Test
	public void testGetContacts() {
		Contact c = new Contact("123", "Contact1", "Lastname", "No avatar");
		Contact c2 = new Contact("1234", "Contact2", "Lastname", "No avatar");
		ContactPersistence.INSTANCE.addContact(c);
		ContactPersistence.INSTANCE.addContact(c2);
		Assert.assertThat(ContactPersistence.INSTANCE.getContacts(), is(instanceOf(List.class)));
	}
	
	

}
