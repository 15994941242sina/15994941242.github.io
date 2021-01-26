package com.example.controller.commodity;

import com.example.pojo.SellTable;
import com.example.pojo.commodity.Product;
import com.example.pojo.commodity.Shopping;
import com.example.service.SellTableService;
import com.example.service.commodity.ProductService;
import com.example.service.commodity.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-18 14:51
 */
@Controller
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private SellTableService sellTableService;

    @RequestMapping("/addShopping/{product_id}")
    public String addShopping(@PathVariable String product_id,HttpServletResponse response) throws Exception{
        Product product = productService.queryByID(product_id);
        Shopping shopping = shoppingService.queryByID(product_id);
        if(product.getProduct_online() <= 0){
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('【操作失败】商品在架数量为“0”');");
            out.println("history.back();");
            out.println("</script>");
        }else{
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('添加成功！');");
            out.println("history.back();");
            out.println("</script>");
            //如果在数据库中已经存在，直接+1即可
            if(shopping != null){
                shoppingService.updateCount(product_id,shopping.getProduct_count()+1,shopping.getProduct_export_price()*(shopping.getProduct_count()+1));
            }else {
                shopping = new Shopping();
                shopping.setProduct_id(product.getProduct_id());
                shopping.setProduct_name(product.getProduct_name());
                shopping.setProduct_count(1);
                shopping.setProduct_export_price(product.getProduct_export_price());
                shopping.setProduct_total(shopping.getProduct_count()*shopping.getProduct_export_price());
                int test = shoppingService.addShopping(shopping);
                System.out.println(shopping);
                System.out.println(test);
            }
        }
        return "";
    }

    //数量加一
    @RequestMapping("/addOne/{product_id}")
    public String addOne(@PathVariable String product_id,HttpServletResponse response) throws Exception{
        Product product = productService.queryByID(product_id);
        Shopping shopping = shoppingService.queryByID(product_id);
        if(product.getProduct_online() <= 0){
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('【操作失败】商品在架数量为“0”');");
            out.println("history.back();");
            out.println("</script>");
            return null;
        }else{
            shoppingService.updateCount(product_id,shopping.getProduct_count()+1,(shopping.getProduct_export_price()*(shopping.getProduct_count()+1)));
            return "redirect:/shopping/queryAll";
        }

    }

    //数量减一
    @RequestMapping("/subOne/{product_id}")
    public String subOne(@PathVariable String product_id, HttpServletResponse response) throws Exception{
        Shopping shopping = shoppingService.queryByID(product_id);
        if(shopping.getProduct_count() == 1){
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('【操作失败】商品数量为“1”');");
            out.println("history.back();");
            out.println("</script>");
            return null;
        }else {
            shoppingService.updateCount(product_id,shopping.getProduct_count()-1,(shopping.getProduct_export_price()*(shopping.getProduct_count()-1)));
            return "redirect:/shopping/queryAll";
        }
    }

    //移除一条商品
    @RequestMapping("/removeAll/{product_id}")
    public String removeAll(@PathVariable String product_id){
        shoppingService.deleteShopping(product_id);
        return "redirect:/shopping/queryAll";
    }

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        double total =0;
        List<Shopping> shoppings = shoppingService.queryAll();
        for(Shopping shopping:shoppings){
            total += shopping.getProduct_total();
        }
        model.addAttribute("shoppingCar",shoppings);
        model.addAttribute("total",total);
        return "/product/shoppingcar";
    }

    //提交订单
    @RequestMapping("/order")
    public String order(){
        SellTable sellTable = new SellTable();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMHHhhmmss");
        sellTable.setSell_id(sdf.format(date));
        List<Shopping> shoppings = shoppingService.queryAll();
        for (Shopping shopping : shoppings){
            //【1】修改商品表
            Product product = productService.queryByID(shopping.getProduct_id());
            productService.updateOne(shopping.getProduct_id(),(product.getProduct_sold()-shopping.getProduct_count()),(product.getProduct_sold()+1));
            //【2】修改订单表
            sellTable.setSell_name(shopping.getProduct_name());
            sellTable.setSell_product_number(shopping.getProduct_count());
            sellTable.setSell_product_type(product.getProduct_class());
            sellTable.setSell_price(shopping.getProduct_export_price());
            sellTable.setSell_total(shopping.getProduct_total());
            sellTableService.addSellTable(sellTable);
        }
        //【3】清空购物表
        shoppingService.deleteAll();
        return "redirect:/product/queryAll";
    }

}
