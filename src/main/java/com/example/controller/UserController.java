package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * com.example.controller
 *
 * @author foam
 * create 2020-12-16
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<User> users = userService.queryAllUser();
        System.out.println("【user】"+users);
        model.addAttribute("allUsers",users);
        return "/user/user-table";
    }

    @RequestMapping("/toInsertUser")
    public String toInsertUser(){
        return "/user/toInsertUser";
    }

    @RequestMapping("/insertUser")
    public String insertUser(User user){
        userService.addUser(user);
        return "redirect:/user/queryAll";
    }

    @RequestMapping("/toUpdateUser/{user_id}")
    public String toUpdateVip(Model model,@PathVariable int user_id){
        //通过id读取需要修改的user对象
        User user = userService.queryUserById(user_id);
        System.out.println("要修改的用户id是"+user_id);
        System.out.println("修改的对象是"+user);
        model.addAttribute("user",user);
        return "/user/toUpdateUser";
    }

    @RequestMapping("/updateUser")
    public String updateVip(User user){
        System.out.println("执行更新操作");
        userService.updateUser(user);
        return "redirect:/user/queryAll";
    }

    @RequestMapping("/deleteUser/{user_id}")
    public String deleteUser(@PathVariable int user_id){
        System.out.println("执行删除操作");
        userService.deleteUser(user_id);
        return "redirect:/user/queryAll";
    }
}
