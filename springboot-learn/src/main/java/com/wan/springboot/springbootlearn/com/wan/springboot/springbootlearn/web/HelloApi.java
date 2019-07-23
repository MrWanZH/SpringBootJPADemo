package com.wan.springboot.springbootlearn.com.wan.springboot.springbootlearn.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller类
 *
 * @Author wan
 * @Create 2019/7/23 9:36
 * @URI http://localhost:3030/learn/api/v1/hello/say/nihao
 */
@RestController
@RequestMapping("/api/v1/hello")
public class HelloApi {

    @RequestMapping(value = "/say/{name}", method = RequestMethod.GET)
    String sayHello(@PathVariable String name) {//参数 name 前面的 PathVariable 注解用来声明这个参数从服务的 url 路径中获取。
        return "Hello," + name + "!";
    }

    @RequestMapping(value = "/say2/{name}", method = RequestMethod.GET)
    public ModelAndView sayHello2(@PathVariable String name){
        ModelAndView model = new ModelAndView();
        model.setViewName("/views");
        return model;
    }
}
