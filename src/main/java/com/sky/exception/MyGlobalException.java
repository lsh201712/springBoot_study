package com.sky.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义HandlerExceptionResolver类处理异常
 * 需要实现HandlerExceptionResolver接口
 */
@Configuration
public class MyGlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

       ModelAndView mv =  new ModelAndView();
       //判断不同异常类型,做不同视图的跳转
        if (e instanceof  ArithmeticException){
            mv.setViewName("error1");
        }

        if (e instanceof NullPointerException){
            mv.setViewName("error2");
        }

        mv.addObject("error",e.toString()+"222222222");

        return  mv;
    }
}
