package com.sky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionDemoController {

    @RequestMapping("show")
    public String showInfo(){
        String str =null;
        str.length();
        return "index";
    }

    @RequestMapping("show2")
    public String showInfo2(){
        int a =10/0;
        return "index";
    }
    /**
     * springBoot 异常处理
     * 默认错误视图为error.html
     */

    /**
     * 针对这一个controller
     * java.lang.ArithmeticException
     * 异常处理
     * 该方法需要返回一个ModelAndView 目的是可以让我们封装异常信息以及视图的指定
     * 参数Exception e：会将产生的异常对象注入到方法中
     * @param e
     * @return
     */

  /*  @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error1");
        return  mv;
    }*/

    /**
     * 捕获java.lang.NullPointerException的异常
     * 自定义错误视图
     * @param e
     * @return
     */
  /*  @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullPointerExceptionHandler(Exception e){
        ModelAndView mv  = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error1");
        return  mv;
    }*/



}
