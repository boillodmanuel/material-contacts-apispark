package net.apispark.webapi.db;


import net.apispark.webapi.representation.Contact;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Charly on 26/10/2016.
 */
public class ContactPersistanceTest {
    @Test
    public void addContactTest1() throws Exception {
        Contact exemple = new Contact();
        ContactPersistence.INSTANCE.addContact(exemple);
        Assert.assertNotEquals(null, exemple.getId());
    }


    @Test
    public void addContactTest2() throws Exception{
        Contact exemple = new Contact();
        ContactPersistence.INSTANCE.addContact(exemple);
        Assert.assertEquals(exemple, ContactPersistence.INSTANCE.getContact(exemple.getId()));
    }

}
