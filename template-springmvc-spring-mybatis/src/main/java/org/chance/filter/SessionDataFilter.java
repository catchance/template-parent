package org.chance.filter;

import org.apache.commons.lang.StringUtils;
import org.chance.utils.CookieUtils;
import org.chance.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wqg on 2015/11/26.
 */
public class SessionDataFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(SessionDataFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("filter init!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        //设置cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            String sessionId = CookieUtils.getCookieValue(req, "key");
            if (StringUtils.isBlank(sessionId)) {
                sessionId = UUIDUtils.base58Uuid();
                CookieUtils.setCookie(req, (HttpServletResponse)response,"key", sessionId, -1);
            }
        }


        //调用下一个过滤器
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("filter destroy!");
    }
}
