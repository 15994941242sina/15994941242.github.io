package com.example.mapper;

import com.example.pojo.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LinJie
 * @create 2020-12-11 14:07
 */
@Repository
@Mapper
public interface VipMapper {
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
