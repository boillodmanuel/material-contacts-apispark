package net.apispark.webapi;

import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author Manuel Boillod
 */
public class DummyTest {
    
    @Test
    public void dummy_assertion() throws Exception {
        Assert.assertThat("test is good", is(instanceOf(String.class)));
    }



}
