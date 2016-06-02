package org.hello.xml;

/**
 * Created by wqg on 2015/11/20.
 */

public class MessagePrinter {

    private MessageService messageService;

    public MessagePrinter(MessageService messageService){
        this.messageService=messageService;
    }

    public void printMessage(){
        System.out.println(this.messageService.getMessage());
    }
}
