package com.project.shop.service;

import com.project.shop.entity.dto.OrderStateCountDTO;
import com.project.shop.entity.pojo.Order;
import com.project.shop.entity.pojo.Page;

import java.util.List;

public interface OrderService {
    Page findOrderData(Integer pageNum, Integer pageSize, Integer mode);

    int updateOrderData(Order order);

    int addOrderData(Order order);

    int delOrderData(Integer id);

    List<OrderStateCountDTO> getOrderCategory();
}
