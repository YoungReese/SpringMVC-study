package com.ly.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ly.pojo.User;
import com.ly.utils.JacksonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @RestController 表示controller类中所有方法都是直接返回字符串，不走视图解析器
@Controller
public class UserController {

    @RequestMapping("/j1")
    @ResponseBody  // 加上这个注解，它就不会走视图解析器，会直接返回一个字符串到前端（如果类上有@RestController，这里就不需要这个了）
    public String json1() throws JsonProcessingException {

        User user1 = new User("ly-01", 18, "male");
        User user2 = new User("ly-02", 19, "male");
        User user3 = new User("ly-03", 20, "male");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // jackson  ObjectMapper
        return new ObjectMapper().writeValueAsString(userList);


//        // 直接返回user.toString()，不走试图解析器，前端也可以接收到
//        return user1.toString();
    }



    @RequestMapping("/j2")
    @ResponseBody  // 加上这个注解，它就不会走视图解析器，会直接返回一个字符串到前端（如果类上有@RestController，这里就不需要这个了）
    public String json2() throws JsonProcessingException {
        Date date = new Date();
        // ObjectMapper，时间解析后的默认格式是Timestamp（时间戳）
        // 自定义日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new ObjectMapper().writeValueAsString(sdf.format(date));
    }

    @RequestMapping("/j3")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        // 使用Jackson创建mapper
        ObjectMapper mapper = new ObjectMapper();
        // mapper先关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 设置自定义的时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        Date date = new Date();
        return mapper.writeValueAsString(date);
    }

    // 以下两个函数使用自己抽象的JacksonUtils工具类完成
    @RequestMapping("/j4")
    @ResponseBody
    public String json4() {
        Date date = new Date();
        return JacksonUtils.getJackson(date, "yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/j5")
    @ResponseBody
    public String json5() {
        return JacksonUtils.getJackson(new Date());
    }

}
