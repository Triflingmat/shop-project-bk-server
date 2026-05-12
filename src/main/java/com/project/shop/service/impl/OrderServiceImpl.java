package com.project.shop.service.impl;


import com.project.shop.entity.dto.OrderStateCountDTO;
import com.project.shop.entity.pojo.Order;
import com.project.shop.entity.pojo.Page;
import com.project.shop.mapper.OrderMapper;
import com.project.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderStateCountDTO> getOrderCategory(){
        return orderMapper.getOrderCategory();}

    @Override
    public Page findOrderData(Integer pageNum, Integer pageSize, Integer mode){
        int offset = (pageNum - 1) * pageSize;
        List<Order> list = orderMapper.findOrderData(offset,pageSize,mode);
        long total = orderMapper.getOrderCount(mode);
        Page<Order> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setList(list);
        page.setTotal(total);
        return page;
    }

    @Override
    public Page findUserOrderData(Integer pageNum, Integer pageSize, Integer mode, Integer userId){
        int offset = (pageNum - 1) * pageSize;
        List<Order> list = orderMapper.findOrderDataByUser(offset, pageSize, mode, userId);
        long total = orderMapper.getOrderCountByUser(mode, userId);
        Page<Order> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setList(list);
        page.setTotal(total);
        return page;
    }

    @Override
    public int updateOrderData(Order order){return orderMapper.updateOrderData(order);}

    @Override
    public int addOrderData(Order order){return orderMapper.addOrderData(order);}

    @Override
    public int delOrderData(Integer id){return orderMapper.delOrderData(id);}

}
