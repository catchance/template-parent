package org.hello.xml;

/**
 * Created by wqg on 2015/11/20.
 */

public class MessageServiceImpl implements MessageService {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
