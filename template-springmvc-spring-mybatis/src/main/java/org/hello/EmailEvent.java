package org.hello;

import org.springframework.context.ApplicationEvent;

/**
 * Created by wqg on 2015/11/18.
 */
public class EmailEvent extends ApplicationEvent{

    private static final long serialVersionUID=1l;

    private String address;

    private String text;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EmailEvent(Object source) {
        super(source);
    }

    public EmailEvent(Object source,String address,String text){
        super(source);
        this.address=address;
        this.text=text;
    }

    public void print(){
        System.out.println("hello spring event");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
