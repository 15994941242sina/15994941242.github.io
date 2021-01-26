package com.example.service;

import com.example.pojo.SellTable;

import java.util.List;

public interface SellTableService {
    //查询所有流水号产生的销售信息
    public List<SellTable> querySellTable();

    //按名字查询
    List<SellTable>querySellTableByName(String sell_name);

    //按流水号查询
    List<SellTable>querySellTableById(String sell_id);

    //按类型查询
    List<SellTable>querySellTableByType(String sell_type);

    //模糊查询
    List<SellTable>querySellTableBySomething(String sell_id,String sell_name,String sell_type);

    //插入记录
    int addSellTable(SellTable sellTable);

}
