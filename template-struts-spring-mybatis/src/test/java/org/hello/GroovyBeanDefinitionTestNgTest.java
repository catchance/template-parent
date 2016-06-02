package org.hello;

import static org.testng.Assert.*;

import org.hello.xml.MessagePrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by wqg on 2015/11/20.
 */
public class GroovyBeanDefinitionTestNgTest {

    private final static Logger logger = LoggerFactory.getLogger(GroovyBeanDefinitionTestNgTest.class);

    ApplicationContext ctx;

    @BeforeClass
    public void beforeClass() {
        System.out.println("this is before class");
        /*加载配置文件*/
        ctx = new GenericGroovyApplicationContext("classpath:applicationContext.groovy");
        assertNotNull(ctx);
    }

    @Test
    public void test(){

        HelloWorld hello1= (HelloWorld) ctx.getBean("helloWorldGroovy1");
        HelloWorld hello2= (HelloWorld) ctx.getBean("helloWorldGroovy2");
        HelloWorld hello3= (HelloWorld) ctx.getBean("helloWorldGroovy3");
        HelloWorld hello4= (HelloWorld) ctx.getBean("helloWorldGroovy4");

        assertNotNull(hello1);
        assertNotNull(hello4);
        assertEquals(hello2.getMessage(),"groovy config bean one!");
        assertEquals(hello3.getMessage(),"groovy config bean");
        assertEquals(hello3.getIntVal(),1);
        assertEquals(hello3.getLists().size(),2);
        assertEquals(hello3.getMaps().size(),2);

        logger.info(hello1.toString());
        logger.info(hello2.toString());
        logger.info(hello3.toString());
        logger.info(hello4.toString());

    }

    @Test
    public void test1(){
        MessagePrinter messagePrinter= (MessagePrinter) ctx.getBean("messagePrinter");
        assertNotNull(messagePrinter);
        messagePrinter.printMessage();
        Map map= (Map) ctx.getBean("map");
        assertEquals(map.size(),2);
        logger.info(((Map) ctx.getBean("map")).toString());
    }

    @AfterClass
    public void afterClass() {
        System.out.println("this is after class");
    }

}