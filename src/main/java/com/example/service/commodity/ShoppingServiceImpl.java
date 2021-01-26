package com.example.service.commodity;

import com.example.mapper.commodity.ShoppingMapper;
import com.example.pojo.commodity.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-18 14:49
 */
@Service
public class ShoppingServiceImpl implements ShoppingService{
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public List<Shopping> queryAll() {
        return shoppingMapper.queryAll();
    }

    @Override
    public int addShopping(Shopping shopping) {
        return shoppingMapper.addShopping(shopping);
    }

    @Override
    public Shopping queryByID(String product_id) {
        return shoppingMapper.queryByID(product_id);
    }

    @Override
    public int updateCount(String product_id, int product_count,double product_total) {
        return shoppingMapper.updateCount(product_id, product_count,product_total);
    }

    @Override
    public int deleteShopping(String product_id) {
        return shoppingMapper.deleteShopping(product_id);
    }

    @Override
    public int deleteAll() {
        return shoppingMapper.deleteAll();
    }
}
