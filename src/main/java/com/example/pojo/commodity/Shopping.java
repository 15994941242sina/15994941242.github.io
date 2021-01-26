package com.example.pojo.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LinJie
 * @create 2020-12-18 14:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shopping {
    private String product_id;
    private String product_name;
    private int product_count;
    private double product_export_price;
    private double product_total;
}
