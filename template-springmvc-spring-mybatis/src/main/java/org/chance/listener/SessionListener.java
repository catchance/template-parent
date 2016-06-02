package org.chance.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by wqg on 2015/11/26.
 */
public class SessionListener implements HttpSessionListener {

    private final static Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("session Created!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("session Destroyed!");
    }
}
