package com.example.service;

import com.example.mapper.VipMapper;
import com.example.pojo.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-11 14:19
 */
@Service
public class VipServiceImpl implements VipService{

    @Autowired
    private VipMapper vipMapper;

    @Override
    public List<Vip> queryAll() {
        return vipMapper.queryAll();
    }

    @Override
    public int addVip(Vip vip) {
        return vipMapper.addVip(vip);
    }

    @Override
    public int updateVip(Vip vip) {
        return vipMapper.updateVip(vip);
    }

    @Override
    public int deleteVip(int vip_id) {
        return vipMapper.deleteVip(vip_id);
    }

    @Override
    public Vip queryVip(int vip_id) {
        return vipMapper.queryVip(vip_id);
    }
}
