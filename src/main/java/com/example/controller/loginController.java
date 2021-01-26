package com.example.controller;

import com.example.pojo.User;
import com.example.pojo.commodity.Product;
import com.example.service.UserService;
import com.example.service.commodity.ProductService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LinJie
 * @create 2020-11-29 22:43
 */
@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/welcome")
    public String welcome(@RequestParam String username,@RequestParam String password, Model model, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            session.setAttribute("loginUser", username);
            List<Product> products = productService.queryAll();
            model.addAttribute("allProducts",products);
            subject.login(token);
            return "data-tables";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "index";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "index";
        }
//        User user = userService.queryUser(username);
//        if(user == null){
//            session.setAttribute("loginUser", username);
//            model.addAttribute("msg", "用户不存在");
//            return "index";
//        }else{
//            if(username.equals(userService.queryUser(username).getUser_name()) && password.equals(user.getUser_pwd())){
//                session.setAttribute("loginUser", username);
//                List<Product> products = productService.queryAll();
//                model.addAttribute("allProducts",products);
//                System.out.println("【debug:ProductController】"+products);
//                return "data-tables";
//            }else {
//            model.addAttribute("msg", "密码错误");
//            return "index";
//        }
//        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }

//    @RequestMapping("/login/toaddUser")
//    public String toAddUser(){
//        return "/addUser";
//    }
//
//    @RequestMapping("/login/addUser")
//    public String addUser(User user){
//        System.out.println(user);
//        userService.addUser(user);
//        return "index";
//    }
//
//    @RequestMapping("/toUpdateUser")
//    public String toUpdateUser(){
//        return "updateUser";
//    }

//    @RequestMapping("/updateUser")
//    public String updateUser(User user){
//        userService.updateUser(user);
//        return "redirect:/main.html";
//    }
}
