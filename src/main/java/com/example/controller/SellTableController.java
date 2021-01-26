package com.example.controller;


import com.example.pojo.SellTable;
import com.example.service.SellTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/selltable")
public class SellTableController {
    @Autowired
    private SellTableService sellTableService;
    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<SellTable> sellTables = sellTableService.querySellTable();
        System.out.println(sellTables);
        model.addAttribute("allsellTables",sellTables);
        return "sell-table";
    }

    @RequestMapping("/querySellTableBySomething")
    public String querySellTableBySomething( @RequestParam("sellId") String sellId,
                                           @RequestParam("sellName") String sellName,
                                           @RequestParam("sellClass") String sellClass,
                                           Model model)
    {
        System.out.println(sellId);
        System.out.println(sellName);
        System.out.println(sellClass);
        List<SellTable> sellTables = sellTableService.querySellTableBySomething(sellId,sellName,sellClass);
        System.out.println("模糊查询:"+sellTables);
        model.addAttribute("allsellTables",sellTables);
        return "sell-table";
    }
}
