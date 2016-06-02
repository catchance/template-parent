package org.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wqg on 2015/11/18.
 */
public class MyBeanPostProcesser implements BeanPostProcessor{

    private final static Logger logger = LoggerFactory.getLogger(MyBeanPostProcesser.class);

    private Map map=new ConcurrentHashMap(100);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        MyProxy proxy=new MyProxy();

        if (beanName.contains("DB")) {
            return bean;
        }

        if (bean.toString().contains("Proxy")) {
            logger.info(beanName + "为代理类,不进行再次代理!");
            return bean;
        }

        if (beanName.contains("TransactionTemplate")) {
            logger.info(beanName + "为TransactionTemplate类,不进行再次代理!该类为:" + bean);
            return bean;
        }

        if (map.get(beanName) != null) {
            logger.info(beanName + "已经代理过,不进行再次代理!");
            return map.get(beanName);
        }

        proxy.setObj(bean);
        proxy.setName(beanName);
        Class[] iterClass=bean.getClass().getInterfaces();

        if (iterClass.length > 0) {
            Object proxyO = Proxy.newProxyInstance(bean.getClass().getClassLoader(), iterClass, proxy);
            map.put(beanName, proxyO);
            return proxyO;
        } else {
            logger.info(beanName + "么有接口不进行代理!");
            return bean;
        }

    }
}
