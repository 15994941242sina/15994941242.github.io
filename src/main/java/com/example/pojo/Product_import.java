package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * com.example.pojo
 *
 * @author foam
 * create 2020-12-17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_import {
    private int product_id;
    private String product_name;
    private int product_number;
    private double product_price_total;
    private String product_type;
}
