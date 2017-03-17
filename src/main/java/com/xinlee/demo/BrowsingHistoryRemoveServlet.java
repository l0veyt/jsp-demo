package com.xinlee.demo;

import com.xinlee.demo.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xin.lee on 2017/3/11.
 * 清楚商品浏览记录
 */
public class BrowsingHistoryRemoveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtil.getCookieByName(cookies, "BrowsingHistory");
        if(null != cookie) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        request.getRequestDispatcher(request.getContextPath() + "/product.jsp").forward(request, response);
    }
}
