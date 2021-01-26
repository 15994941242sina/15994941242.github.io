package com.example.service.commodity;

import com.example.pojo.commodity.Shopping;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-18 14:48
 */
public interface ShoppingService {
    //显示购物车内的所有商品记录
    List<Shopping> queryAll();

    //插入一条商品记录
    int addShopping(Shopping shopping);

    //查询一件商品记录
    Shopping queryByID(String product_id);

    //修改一件商品记录（只能更改数量）
    int updateCount(String product_id,int product_count,double product_total);

    //删除一件商品记录
    int deleteShopping(String product_id);

    //清空表所有记录
    int deleteAll();
}
