package com.example.controller.commodity;

import com.example.pojo.commodity.Product;
import com.example.service.commodity.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-11 10:10
 */
@Controller
@RequestMapping("/product")
public class productController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<Product> products = productService.queryAll();
        model.addAttribute("allProducts",products);
        return "data-tables";
    }

    //根据ID查询：
    @RequestMapping("/toQueryID")
    public String toQueryID(String id){
        return "product/queryProdID";
    }

    @RequestMapping("/queryID")
    public String queryID(String ProdID, Model model){
        Product product = productService.queryByID(ProdID);
        System.out.println("【productID】"+product);
        model.addAttribute("allProducts",product);
        return "data-tables";
    }

    //根据名称查询：
    @RequestMapping("/toQueryName")
    public String toQueryName(String name){
        return "product/queryProdName";
    }

    @RequestMapping("/queryName")
    public String queryName(String ProdName, Model model){
        Product product = productService.queryByName(ProdName);
        System.out.println("【productName】"+product);
        model.addAttribute("allProducts",product);
        return "data-tables";
    }

    //根据类别查询：
    @RequestMapping("/toQueryClass")
    public String toQueryClass(String id){
        return "product/queryProdClass";
    }

    @RequestMapping("/queryClass")
    public String queryClass(String ProdClass, Model model){
        List<Product> products = productService.queryByClass(ProdClass);
        System.out.println("【productClass】"+products);
        model.addAttribute("allProducts",products);
        return "data-tables";
    }

    @RequestMapping("/queryProductBySomething")
    public String queryProductBySomething( @RequestParam("proId") String proId,
                                           @RequestParam("proName") String proName,
                                          @RequestParam("proClass") String proClass,
                                          Model model)
    {
        System.out.println(proName);
        System.out.println(proId);
        System.out.println(proClass);
        List<Product> products = productService.queryBySomething(proId,proName,proClass);
        System.out.println("模糊查询:"+products);
        model.addAttribute("allProducts",products);
        return "data-tables";
    }

}
