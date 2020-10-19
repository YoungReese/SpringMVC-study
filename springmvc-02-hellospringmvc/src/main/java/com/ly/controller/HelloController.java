package com.ly.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//注意：这里我们先导入Controller接口 (step5)
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        //ModelAndView 模型和视图
        ModelAndView modelAndView = new ModelAndView();

        //封装对象，放在ModelAndView中。Model
        modelAndView.addObject("msg","HelloSpringMVC! I am coming!");

        //封装要跳转的视图，放在ModelAndView中
        modelAndView.setViewName("hellomvc"); //: /WEB-INF/jsp/hellomvc.jsp

        return modelAndView;
    }
}
