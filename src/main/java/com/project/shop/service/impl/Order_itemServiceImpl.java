package com.project.shop.service.impl;

import com.project.shop.entity.pojo.Order_item;
import com.project.shop.mapper.Order_itemMapper;
import com.project.shop.service.Order_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class Order_itemServiceImpl implements Order_itemService {

    @Autowired
    private Order_itemMapper order_itemMapper;

    @Override
    public BigDecimal getRevenue(){return order_itemMapper.getRevenue();}

    @Override
    public List<Order_item> findOrder_itemData(Integer id){

        return order_itemMapper.findOrder_itemData(id);
    }

    @Override
    public int updateOrder_itemData(Order_item order_item){return order_itemMapper.updateOrder_itemData(order_item);}

    @Override
    public int addOrder_itemData(Order_item order_item){return order_itemMapper.addOrder_itemData(order_item);}

    @Override
    public int delOrder_itemData(Integer id){return order_itemMapper.delOrder_itemData(id);}

}
