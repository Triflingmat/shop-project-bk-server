package com.project.shop.mapper;


import com.project.shop.entity.pojo.Order_item;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface Order_itemMapper {

    @Select("SELECT SUM(price * quantity) AS total_amount FROM `order_item`")
    BigDecimal getRevenue();

    @Select("SELECT * FROM `shop_project`.`order_item` WHERE `order_id` = #{id} LIMIT 0,1000;")
    List<Order_item> findOrder_itemData(Integer id);

    @Update("")
    int updateOrder_itemData(Order_item order_item);

    @Insert("")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addOrder_itemData(Order_item order_item);

    @Delete("")
    int delOrder_itemData(Integer id);

}
