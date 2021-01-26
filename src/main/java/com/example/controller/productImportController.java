package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.example.controller
 *
 * @author foam
 * create 2020-12-17
 **/
@Controller
@RequestMapping("/productImport")
public class productImportController {

    @RequestMapping("/import")
    public String importProduct(){
        return "/productImport/toInsertProduct";
    }
}
