package com.xinlee.demo;

import com.xinlee.demo.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by xin.lee on 2017/3/11.
 * Cookie实现记录最近浏览记录
 */
public class BrowsingHistoryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtil.getCookieByName(cookies, "BrowsingHistory");
        if(null != id && !id.isEmpty()) {
            // 如果商品ID不为空再执行
            if(null == cookie) {
                // 如果没有Cookie，则创建
                Cookie newCookie = new Cookie("BrowsingHistory", id + ",");
                request.setAttribute("ids", new String[]{id});
                response.addCookie(newCookie);
            }else {
                // 如果有Cookie，则获取原先的浏览记录
                String value = cookie.getValue();
                String[] ids = value.split(",");
                if(!Arrays.asList(ids).contains(id)) {
                    // 如果原先的浏览记录不包含这个商品ID，则添加
                    value += id + ",";
                    ids = value.split(",");
                    request.setAttribute("ids", ids);
                    cookie.setValue(value);
                    response.addCookie(cookie);
                }else {
                    // 如果原先的浏览记录已经包含了商品ID，则不设置Cookie
                    request.setAttribute("ids", ids);
                }
            }
        }
        request.getRequestDispatcher(request.getContextPath() + "/product.jsp").forward(request, response);
    }
}
