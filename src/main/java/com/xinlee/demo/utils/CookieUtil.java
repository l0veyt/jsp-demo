package com.xinlee.demo.utils;

import javax.servlet.http.Cookie;

/**
 * Created by xin.lee on 2017/3/11.
 * Cookie工具包
 */
public class CookieUtil {

    public static Cookie getCookieByName(Cookie[] cookies, String name) {
        if(null == cookies) {
            return null;
        }else {
            for (Cookie cookie : cookies) {
                if(name.equals(cookie.getName())) {
                    return cookie;
                }
            }
            return null;
        }
    }
}
