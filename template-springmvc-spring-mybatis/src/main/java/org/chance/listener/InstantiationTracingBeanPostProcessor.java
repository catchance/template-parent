package org.chance.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by wqg on 2015/12/24.
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent>{

    Logger logger=LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);

    private ApplicationContext ctx;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // TODO Auto-generated method stub
        if(event.getApplicationContext().getParent() == null){
            //root application context 没有parent，他就是老大.
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            ctx=event.getApplicationContext();

            try{
                logger.info("查询系统数据总数时进行缓存初始化: ");
            }catch(Exception e){
                logger.error("出错: "+ e.toString());
            }
            logger.debug("spring 初始化完成！");
        }
    }
}

