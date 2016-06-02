package org.chance.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wqg on 2015/11/26.
 */
public class CookieUtils {
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookies[] = request.getCookies();
        if (cookies == null || name == null || name.length() == 0) {
            return null;
        }
        for (int i = 0; i < cookies.length; i++) {
            if (name.equals(cookies[i].getName())) { // &&
                // request.getServerName().equals(cookies[i].getDomain()
                return cookies[i];
            }
        }
        return null;
    }

    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        if (cookie == null) {
            return "";
        } else {
            return cookie.getValue();
        }
    }

    public static void deleteCookie(HttpServletRequest request,
                                    HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            doDeleteCookie(request, response, cookie);
        }
    }

    public static void deleteCookie(HttpServletRequest request,
                                    HttpServletResponse response, String name) {
        Cookie cookies[] = request.getCookies();
        if (cookies == null || name == null || name.length() == 0) {
            return;
        }
        for (int i = 0; i < cookies.length; i++) {
            if (name.equals(cookies[i].getName())) { // &&
                Cookie cookie = cookies[i] ;
                doDeleteCookie(request, response, cookie);
            }
        }
    }

    private static void doDeleteCookie(HttpServletRequest request,
                                       HttpServletResponse response, Cookie cookie) {
        cookie.setPath(getPath(request));
        cookie.setValue("");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static void setCookie(HttpServletRequest request,
                                 HttpServletResponse response, String name, String value) {
        setCookie(request, response, name, value, 0x278d00);
    }

    public static void setCookie(HttpServletRequest request,
                                 HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value == null ? "" : value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(getPath(request));
        response.addCookie(cookie);
    }

    private static String getPath(HttpServletRequest request) {
        String path = request.getContextPath();
        return (path == null || path.length() == 0) ? "/" : path;
    }
}
