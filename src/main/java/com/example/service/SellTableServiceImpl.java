package com.example.service;

import com.example.mapper.SellTableMapper;
import com.example.pojo.SellTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellTableServiceImpl implements SellTableService{
    @Autowired
    private SellTableMapper sellTableMapper;
    @Override
    public List<SellTable> querySellTable() {
        return sellTableMapper.querryAllSellTable();
    }

    @Override
    public List<SellTable> querySellTableByName(String sell_name) {
        return sellTableMapper.querySellTableByName(sell_name);
    }

    @Override
    public List<SellTable> querySellTableById(String sell_id) {
        return sellTableMapper.querySellTableById(sell_id);
    }

    @Override
    public List<SellTable> querySellTableByType(String sell_type) {
        return sellTableMapper.querySellTableByType(sell_type);
    }

    @Override
    public List<SellTable> querySellTableBySomething(String sell_id,String sell_name,  String sell_type) {
        return sellTableMapper.querySellTableBySomething(sell_id,sell_name,sell_type);
    }

    @Override
    public int addSellTable(SellTable sellTable) {
        return sellTableMapper.addSellTable(sellTable);
    }
}
