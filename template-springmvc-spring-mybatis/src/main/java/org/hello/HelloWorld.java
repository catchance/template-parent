package org.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Map;

/**
 * Created by chance on 2015/11/7.
 * Spring提供了几个标志接口,初始化回调和析构回调
 */
public class HelloWorld implements InitializingBean,DisposableBean {

    private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    private String message;
    private int intVal;
    private List<String> lists;
    private Map<String,String> maps;

    public HelloWorld(){

    }

    public HelloWorld(String message){
        this.message=message;
    }

    public void init(){
        logger.info("bean init-method() ");
    }

    public void destroyMethod(){
        logger.info("bean destory-method() ");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("世界，你好！");
        logger.info("logback 成功了");
        logger.error("logback 成功了");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "message='" + message + '\'' +
                ", intVal=" + intVal +
                ", lists=" + lists +
                ", maps=" + maps +
                '}';
    }

    public void destroy() throws Exception {
        logger.info("继承DisposableBean的销毁方法！");
    }

    public void afterPropertiesSet() throws Exception {
        logger.info("继承InitializingBean的初始化！");
    }
}
