package org.hello;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by chance on 2015/11/7.
 */
public class JUnitTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCan() {
        String person = new String("Larry");
        assertEquals("Larry", person);
    }

    //1000毫秒没有执行完成也算失败
    @Ignore
    @Test(timeout=1000)
    public void testIgnore(){
    }

    //1000毫秒没有执行完成也算失败
    @Ignore
    @Test(expected=Exception.class)
    public void testException(){
    }
}
