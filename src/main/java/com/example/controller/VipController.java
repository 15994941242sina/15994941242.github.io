package com.example.controller;

import com.example.pojo.Vip;
import com.example.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-11 14:24
 */
@Controller
@RequestMapping("/vip")
public class VipController {

    @Autowired
    private VipService vipService;

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<Vip> vips = vipService.queryAll();
        System.out.println("【vip】"+vips);
        model.addAttribute("allVips",vips);
        return "/vip/vip-tables2";
    }

    @RequestMapping("/toInsertVip")
    public String toInsertVip(){
        return "/vip/toInsertVip";
    }

    @RequestMapping("/insertVip")
    public String insertVip(Vip vip){
        vipService.addVip(vip);
        return "redirect:/vip/queryAll";
    }

    @RequestMapping("/toUpdateVip/{vip_id}")
    public String toUpdateVip(Model model,@PathVariable int vip_id){
        Vip vip = vipService.queryVip(vip_id);
        System.out.println(vip);
        model.addAttribute("vip",vip);
        return "/vip/toUpdateVip";
    }

    @RequestMapping("/updateVip")
    public String updateVip(Vip vip){
        System.out.println(vip);
        vipService.updateVip(vip);
        return "redirect:/vip/queryAll";
    }

    @RequestMapping("/deleteVip/{vip_id}")
    public String deleteVip(@PathVariable int vip_id){
        System.out.println(vip_id);
        vipService.deleteVip(vip_id);
        return "redirect:/vip/queryAll";
    }

}
