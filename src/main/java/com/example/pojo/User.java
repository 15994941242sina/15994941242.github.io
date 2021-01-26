package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LinJie
 * @create 2020-12-03 21:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int user_id;
    private String user_name;
    private int user_type;
    private String user_pwd;
}
