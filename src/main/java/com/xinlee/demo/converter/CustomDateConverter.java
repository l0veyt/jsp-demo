package com.xinlee.demo.converter;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xin.lee on 2017/3/16.
 * 自定义日期转换类
 */
public class CustomDateConverter implements Converter {

    @SuppressWarnings("unchecked")
    public <T> T convert(Class<T> aClass, Object object) {
        String dateStr = (String) object;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (T) date;
    }
}
