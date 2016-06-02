package org.chance.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wqg on 2015/11/25.
 */
public class LogbackConfigListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        LogbackWebConfigurer.initLogging(event.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        LogbackWebConfigurer.shutdownLogging(event.getServletContext());
    }
}
