package org.hello;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by wqg on 2015/11/18.
 */
public class EmailListener implements ApplicationListener{

    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof EmailEvent){
            EmailEvent emailEvent=(EmailEvent)event;
            emailEvent.print();
            System.out.println("the source is:"+emailEvent.getSource());
            System.out.println("the address is:"+emailEvent.getAddress());
            System.out.println("the email's context is:"+emailEvent.getText());
        }
    }
}
