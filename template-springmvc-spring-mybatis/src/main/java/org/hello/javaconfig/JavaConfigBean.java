package org.hello.javaconfig;

import org.hello.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wqg on 2015/11/18.
 * 使用JAVA的方式配置Bean
 */

@Configuration
public class JavaConfigBean {

    @Bean(name="bean4")
    public HelloWorld helloWorld() {
        final HelloWorld helloWorld = new HelloWorld();
        helloWorld.setIntVal(1);
        helloWorld.setMessage("java config spring bean!");
        return helloWorld;
    }

}
