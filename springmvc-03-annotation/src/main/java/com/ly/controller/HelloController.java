package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * liyang 2020-10-19
 * 使用注解开发SpringMVC
 */
@Controller
public class HelloController {

    @RequestMapping("/hellomvc")
    public String hellomvc(Model model) {
        // 封装数据
        model.addAttribute("msg", "Hello SpringMVC! (Use Annotation)");

        return "hellomvc"; // 会被视图解析器处理
    }

}
