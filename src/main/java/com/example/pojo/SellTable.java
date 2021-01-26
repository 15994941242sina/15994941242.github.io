package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellTable {
    private String sell_id;
    private String sell_name;
    private int sell_product_number;
    private String sell_product_type;
    private double sell_price;
    private double sell_total;
}
