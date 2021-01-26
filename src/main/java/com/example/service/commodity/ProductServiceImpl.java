package com.example.service.commodity;

import com.example.mapper.commodity.ProductMapper;
import com.example.pojo.commodity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-11 10:06
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryAll() {
        return productMapper.queryAll();
    }

    @Override
    public Product queryByName(String name) {
        return productMapper.queryByName(name);
    }

    @Override
    public List<Product> queryByClass(String prdClass) {
        return productMapper.queryByClass(prdClass);
    }

    @Override
    public Product queryByID(String id) {
        return productMapper.queryByID(id);
    }

    @Override
    public List<Product> queryBySomething(String proId,String proName, String proClass) {
        return productMapper.queryBySomething(proId,proName,proClass);
    }

    @Override
    public int updateOne(String proId, int product_sold, int product_online) {
        return productMapper.updateOne(proId,product_sold,product_online);
    }

}