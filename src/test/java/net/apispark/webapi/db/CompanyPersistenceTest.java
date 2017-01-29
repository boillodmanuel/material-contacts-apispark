package net.apispark.webapi.db;

import org.junit.Assert;
import org.junit.Test;

import net.apispark.webapi.representation.Contact;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import net.apispark.webapi.db.ContactPersistence ;

/**
 * 
 * @author Vlad
 *
 */

public class CompanyPersistenceTest {

	@Test
    public void addContactTest(){
		
		Contact c = new Contact() ;
        Assert.assertThat(ContactPersistence.INSTANCE.addContact(c).getId(), is(instanceOf(String.class)));
    }
	
	@Test
	public void addContactTest2() {
		Contact c1 = new Contact() ;
		Contact c2 = ContactPersistence.INSTANCE.addContact(c1) ;
		Assert.assertEquals(ContactPersistence.INSTANCE.getContact(c2.getId()), c1) ;
	}
}