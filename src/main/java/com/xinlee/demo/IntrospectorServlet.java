package com.xinlee.demo;

import com.xinlee.demo.javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by xin.lee on 2017/3/16.
 * 内省技术封装数据
 */
public class IntrospectorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

    public void populate(Object object, Map<String, String[]> parameterMap) throws Exception {
        // 解析User这个JavaBean获取Bean的信息
        BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
        // 获取Bean的属性的描述信息
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            // 获取属性的名称
            String name = pd.getName();
            // 请求中传入的参数集合中包含了属性的值
            if(parameterMap.containsKey(name)) {
                // 获取该属性的setter方法
                Method writeMethod = pd.getWriteMethod();
                // 将值设置到对象中
                writeMethod.invoke(object, parameterMap.get(name)[0]);
            }
        }
    }
}
