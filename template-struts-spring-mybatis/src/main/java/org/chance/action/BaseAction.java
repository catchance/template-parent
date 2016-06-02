package org.chance.action;

import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wqg on 2015/12/3.
 */
public class BaseAction extends ActionSupport{

    //虽然ActionSupport中有一个LOG的实例变量，但经实践，发现用LOG对象记录的日志，不受logback.xml配置文件控制
    //这里定义一个logger，以便其子类都可以正常使用logback。
    protected Logger logger= LoggerFactory.getLogger(this.getClass());

}
