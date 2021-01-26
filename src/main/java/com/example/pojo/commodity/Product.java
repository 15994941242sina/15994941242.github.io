package com.example.pojo.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LinJie
 * @create 2020-12-11 9:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String product_id;
    private String product_name;
    private String product_class;
    private double product_import_price;
    private double product_export_price;
    private int product_stock;
    private int product_sold;
    private int product_scrap;
    private int product_online;
    public Product(String proId, String proName, String proClass) {
        this.product_id=proId;
        this.product_name=proName;
        this.product_class=proClass;
    }

}
