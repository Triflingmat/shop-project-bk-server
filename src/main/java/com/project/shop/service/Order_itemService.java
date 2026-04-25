package com.project.shop.service;

import com.project.shop.entity.pojo.Order_item;

import java.math.BigDecimal;
import java.util.List;

public interface Order_itemService {

    BigDecimal getRevenue();

    List<Order_item> findOrder_itemData(Integer id);

    int updateOrder_itemData(Order_item order_item);

    int addOrder_itemData(Order_item order_item);

    int delOrder_itemData(Integer id);
}