package org.chance.action;

import org.springframework.stereotype.Controller;

/**
 * Created by wqg on 2015/12/3.
 */

@Controller
public class HelloWorldAction extends BaseAction{

    private String message;

    public String execute() {
        //log sample
        for(int i=0;i< 1000;i++) {
            logger.trace("logback->trace" + i);
            logger.debug("logback->debug" + i);
            logger.info("logback->info" + i);
            logger.warn("logback->warn" + i);
            logger.error("logback->error" + i);
        }

        return SUCCESS;
    }

    public String sayHello(){
        message = "welcome to SSH!";
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
