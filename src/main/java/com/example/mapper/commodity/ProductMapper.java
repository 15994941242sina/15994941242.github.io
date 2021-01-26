package com.example.mapper.commodity;

import com.example.pojo.commodity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-11 9:31
 */
@Repository
@Mapper
public interface ProductMapper {
    //显示所有商品
    List<Product> queryAll();

    //根据商品名称查询
    Product queryByName(String name);

    //根据商品类别查询
    List<Product> queryByClass(String prdClass);

    //根据商品编号查询
    Product queryByID(String id);

    //模糊查询
    List<Product> queryBySomething(String proId,String proName,String proClass);

    //修改商品在架量和已售量
    int updateOne(String proId,int product_sold,int product_online);
}
