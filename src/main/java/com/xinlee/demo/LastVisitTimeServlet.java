package com.xinlee.demo;

import com.xinlee.demo.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xin.lee on 2017/3/10.
 * Cookie实现记录用户上次访问的时间点
 */
public class LastVisitTimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 当前访问时间
        String currentVisitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Cookie[] cookies = request.getCookies();
        // 获取Cookie
        Cookie cookie = CookieUtil.getCookieByName(cookies, "LastVisitTime");
        if(null == cookie) {
            cookie = new Cookie("LastVisitTime", currentVisitTime);
            response.addCookie(cookie);
            response.getWriter().write("第一次访问，添加Cookie");
        }else {
            // 上次访问时间
            String lastVisitTime = cookie.getValue();
            cookie.setValue(currentVisitTime);
            response.addCookie(cookie);
            response.getWriter().write("上次访问的时间点：" + lastVisitTime);
        }
    }
}
