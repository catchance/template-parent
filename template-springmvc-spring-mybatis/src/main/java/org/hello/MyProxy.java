package org.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wqg on 2015/11/18.
 */
public class MyProxy implements InvocationHandler{

    private final static Logger logger = LoggerFactory.getLogger(MyProxy.class);

    private Object obj;

    private String name;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("begin================" + "bean 名称为【" + name + "】方法为【" + method.getName() + "】========="
                + obj.getClass());
        return method.invoke(obj,args);
    }

    public void printDetail(String detail){
        logger.info(detail);
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
