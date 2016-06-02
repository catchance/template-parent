package org.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Created by wqg on 2015/11/12.
 */
public class MainApp {

    private final static Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {

        /*类路径下寻找配置文件来实例化容器 [推荐使用]*/
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*在文件系统路径下寻找配置文件来实例化容器 [这种方式可以在开发阶段使用]*/
//      ApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{"d:\\beans.xml"});

        /*类路径下寻找配置文件来实例化容器 [推荐使用] [通过groovy方式来配置bean]*/
        final GenericGroovyApplicationContext groovyCtx = new GenericGroovyApplicationContext("applicationContext.groovy");

        HelloWorld bean1= (HelloWorld) ctx.getBean("helloWorld");
        HelloWorld bean2= (HelloWorld) ctx.getBean("helloWorld2");
        HelloWorld bean3= (HelloWorld) ctx.getBean("helloWorld3");
        HelloWorld bean4= (HelloWorld) ctx.getBean("bean4");

        HelloWorld groovyBean1= (HelloWorld) groovyCtx.getBean("helloWorldGroovy1");
        HelloWorld groovyBean2= (HelloWorld) groovyCtx.getBean("helloWorldGroovy2");
        HelloWorld groovyBean3= (HelloWorld) groovyCtx.getBean("helloWorldGroovy3");


        HelloWorld bean11= (HelloWorld) ctx.getBean("helloWorld");
        HelloWorld bean22= (HelloWorld) ctx.getBean("helloWorld2");
        HelloWorld bean33= (HelloWorld) ctx.getBean("helloWorld3");

        bean1.getMessage();
        logger.info(bean1.toString());
        logger.info(bean2.toString());
        logger.info(bean3.toString());
        logger.info(bean4.toString());


        logger.info(bean1==bean11?"singleton":"prototype ");
        logger.info(bean2==bean22?"singleton":"prototype ");
        logger.info(bean3==bean33?"singleton":"prototype ");

        // add a shutdown hook for the above context...

        EmailEvent event = new EmailEvent("hello","boylmx@163.com","this is a email text!");

        ctx.publishEvent(event);

        ctx.close();

    }

}
