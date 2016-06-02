package org.hello;

import org.hello.annotation.MessagePrinter;
import org.hello.annotation.XmlBean;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;

/**
 * Created by wqg on 2015/11/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.groovy",loader = GenericGroovyContextLoader.class)
public class GroovyBeanDefinitionJunitTest {


    @Autowired(required=false)
    private MessagePrinter messagePrinter;

    @Autowired(required=false)
    private XmlBean xmlBean;

    @Test
    @Ignore
    public void test(){

    //    Assert.assertNotNull(xmlBean);
    //    messagePrinter.printMessage();

    }


    @Test
    public void test1(){
//        messagePrinter.printMessage();
        Assert.assertNull(xmlBean);
    }

}
