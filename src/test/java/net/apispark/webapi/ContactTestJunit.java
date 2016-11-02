package net.apispark.webapi;
import static org.junit.Assert.*;

import org.junit.Test;

import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;

import org.junit.Assert;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;


public class ContactTestJunit {

	@Test
	//adding a new contact should return the created contact with an assigned id
	public void test1() {
		Contact john = ContactPersistence.INSTANCE.addContact(new Contact("41ee2e80-75bf-11e5-b476-cbcba715b961", "John", "Smith", "svg-1", "Male"));
		Assert.assertThat(john, is(instanceOf(Contact.class)));
		Assert.assertThat(john.getId(), is(instanceOf(String.class)));
	}
	
	
	@Test
	//adding a new contact then requesting it by id should return the contact
	public void test2() {
		Contact brenda = ContactPersistence.INSTANCE.addContact(new Contact("41ee5590-75bf-11e5-b476-cbcba715b961", "Brenda", "Jones", "svg-6", "Female"));
		Assert.assertEquals(ContactPersistence.INSTANCE.getContact("41ee5590-75bf-11e5-b476-cbcba715b961"), brenda);
	}
	@Test
	//adding a new contact then requesting it by id should return the contact
	public void testTravis() {
		Contact brenda = ContactPersistence.INSTANCE.addContact(new Contact("41ee5590-75bf-11e5-b476-cbcba715b961", "Brenda", "Jones", "svg-6", "Female"));
		Assert.assertEquals(ContactPersistence.INSTANCE.getContact("41ee5590-75bf-11e5-b476-cbcba715b961"), brenda);
	}
}