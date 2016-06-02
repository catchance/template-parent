package org.hello.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by wqg on 2015/11/20.
 */

@Component
public class MessageServiceImpl implements MessageService{

    @Autowired
    @Qualifier("message")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
