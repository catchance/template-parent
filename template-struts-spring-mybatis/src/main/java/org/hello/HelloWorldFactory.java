package org.hello;

/**
 * Created by wqg on 2015/11/13.
 */
public class HelloWorldFactory {

    //静态工厂方法实例化
    public static HelloWorld createHelloWrold(){

        return new HelloWorld("from static factory create");

    }

    //实例工厂方法实例化
    public HelloWorld instaceHelloWorld(){
        return new HelloWorld("from factory create");
    }
}
