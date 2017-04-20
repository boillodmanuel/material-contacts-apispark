package net.apispark.webapi;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Manuel Boillod
 */
public class DummyTest {
    
    @Test
    public void dummy_assertion() throws Exception {
        Assert.assertThat("test is good", is(instanceOf(String.class)));
    }
    
    @Test
    public void dummy_assertion_2() throws Exception {
        Assert.assertThat(1, is(instanceOf(Integer.class)));
    }
}
