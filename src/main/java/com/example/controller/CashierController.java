package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LinJie
 * @create 2020-12-13 10:49
 */
@Controller
public class CashierController {

    @RequestMapping("/cashier")
    public String toCashier(){
        return "/product/shoppingcar";
    }

}
