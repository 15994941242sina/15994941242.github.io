package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LinJie
 * @create 2020-12-11 14:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vip {

    private String vip_id;
    private String vip_name;
    private String vip_telephone;
    private String vip_address;

}
