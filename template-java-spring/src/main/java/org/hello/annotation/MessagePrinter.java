package org.hello.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wqg on 2015/11/20.
 */

@Component
public class MessagePrinter {

    @Autowired
    private MessageService messageService;

    @Autowired
    public MessagePrinter(MessageService messageService){
        this.messageService=messageService;
    }

    public void printMessage(){
        System.out.println(this.messageService.getMessage());
    }
}
