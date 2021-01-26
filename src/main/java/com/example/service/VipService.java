package com.example.service;

import com.example.pojo.Vip;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-11 14:18
 */
public interface VipService {
    //查询所有vip
    List<Vip> queryAll();

    //添加vip
    public int addVip(Vip vip);

    //修改vip
    public int updateVip(Vip vip);

    //删除vip
    public int deleteVip(int vip_id);

    //查找一个vip
    public Vip queryVip(int vip_id);
}
