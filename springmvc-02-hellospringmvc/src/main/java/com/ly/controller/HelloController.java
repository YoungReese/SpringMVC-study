package com.ly.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * liyang 2020-10-19
 * 这里的 "step + 数字" 标注了SpringMVC执行的流程！
 * 具体的流程见博客，对着本代码看！
 * 如果需要深入理解，使用流程图对着源码看（着重关注过程和当前的处理任务！）
 */

// 注意：这里我们先导入Controller接口 (step5)
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        // ModelAndView 模型和视图
        ModelAndView modelAndView = new ModelAndView();

        // 封装对象，放在ModelAndView中（在本语句前面可以进行业务的处理！）
        modelAndView.addObject("msg","Hello SpringMVC! I AM COMING!");

        // 封装要跳转的视图，放在ModelAndView中
        modelAndView.setViewName("hellomvc"); //: /WEB-INF/jsp/hellomvc.jsp

        return modelAndView;
    }
}
