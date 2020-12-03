package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author LinJie
 * @create 2020-11-29 22:43
 */
@Controller
public class loginController {
    @RequestMapping("/welcome")
    public String welcome(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        if ("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户或密码错误");
            return "login";
        }
    }
}
