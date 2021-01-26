package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * com.example.controller
 *
 * @author foam
 * create 2020-12-17
 **/
@Controller
public class kunController {

    @RequestMapping("/kun")
    public ModelAndView test(@RequestParam("kunname") String name ,@RequestParam("password") String pwd,@RequestParam("select") String select){
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(select);
        int a = Integer.parseInt(select);
        return new ModelAndView("redirect:/toList");

    }

    @RequestMapping("/testTH")
    public String testTH(){
        return "kun";
    }



    @RequestMapping("/testTH/1/{name}")
    public String testTH1(@PathVariable String name){
        System.out.println("传到1来了，名字是");
        System.out.println("11111111111");
        return "test";
    }

    @RequestMapping("/testTH/2/{name}")
    public String testTH2(@PathVariable String name){
        System.out.println("传到2来了，名字是");
        System.out.println("22222222222");
        return "test";
    }
}
