package org.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chance on 2015/11/7.
 */
public class HelloWorld {
    private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("世界，你好！");
        logger.info("logback 成功了");
        logger.error("logback 成功了");
    }
}
