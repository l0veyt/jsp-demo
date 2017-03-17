package com.xinlee.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xin.lee on 2017/3/11.
 * Session实现购物车
 */
public class ShoppingCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取要添加到购物车的商品ID
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        Map<String, Integer> shoppingCart = (Map<String, Integer>) session.getAttribute("shoppingCart");
        if(null == shoppingCart) {
            shoppingCart = new HashMap<String, Integer>();
            shoppingCart.put(id, 1);
            session.setAttribute("shoppingCart", shoppingCart);
        }else {
            if(shoppingCart.containsKey(id)) {
                shoppingCart.put(id, shoppingCart.get(id) + 1);
            }else {
                shoppingCart.put(id, 1);
            }
            session.setAttribute("shoppingCart", shoppingCart);
        }
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
}
