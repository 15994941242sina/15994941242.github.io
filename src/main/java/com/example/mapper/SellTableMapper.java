package com.example.mapper;


import com.example.pojo.SellTable;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SellTableMapper {
    //全部销售单查询
    List<SellTable> querryAllSellTable();

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
