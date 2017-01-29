package net.apispark.webapi.db;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.apispark.webapi.representation.Contact;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aurelien Zakowic
 */
public class ContactPersistenceTest {

	@Test
	public void creation_should_set_id() throws Exception {
		Contact c = new Contact();
		c.setFirstName("bob");
		Contact contactSaved = ContactPersistence.INSTANCE.addContact(c);
		Assert.assertThat(contactSaved.getId(), is(notNullValue()));
	}

}
