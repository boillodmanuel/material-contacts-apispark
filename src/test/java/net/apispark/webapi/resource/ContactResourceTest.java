package net.apispark.webapi.resource;

import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;
import net.apispark.webapi.representation.enums.Gender;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Manuel Boillod
 */
public class ContactResourceTest {


    @Test
    public void added_contact_is_correct() throws Exception {
        // given a contact
        Contact contact = new Contact();
        contact.setFirstName("John");
        contact.setLastName("Smith");
        contact.setGender(Gender.MAN);

        // when added
        Contact persistentContact = ContactPersistence.INSTANCE.addContact(contact);

        // then returned contact has an id and is correct
        assertThat(persistentContact, is(notNullValue()));
        assertThat(persistentContact.getId(), is(notNullValue()));
        assertThat(persistentContact.getFirstName(), is("John"));
        assertThat(persistentContact.getLastName(), is("Smith"));
        assertThat(persistentContact.getGender(), is(Gender.MAN));
    }

    @Test
    public void added_contact_is_well_retrieved_by_id() throws Exception {
        // given a added contact
        Contact contact = new Contact();
        contact.setFirstName("Sam");
        contact.setLastName("Sung");
        contact.setGender(Gender.MAN);
        Contact persistentContact = ContactPersistence.INSTANCE.addContact(contact);
        String contactId = persistentContact.getId();

        // when retrieved by id
        Contact retrievedContact = ContactPersistence.INSTANCE.getContact(contactId);

        // then retrieved contact is correct
        assertThat(retrievedContact, is(notNullValue()));
        assertThat(retrievedContact.getId(), is(contactId));
        assertThat(persistentContact.getFirstName(), is("Sam"));
        assertThat(persistentContact.getLastName(), is("Sung"));
        assertThat(persistentContact.getGender(), is(Gender.MAN));
    }
}
