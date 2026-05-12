package com.project.shop.service;

import com.project.shop.entity.dto.OrderStateCountDTO;
import com.project.shop.entity.pojo.Order;
import com.project.shop.entity.pojo.Page;

import java.util.List;

public interface OrderService {
    /** 管理员查看所有订单 */
    Page findOrderData(Integer pageNum, Integer pageSize, Integer mode);

    /** 普通用户查看自己的订单 */
    Page findUserOrderData(Integer pageNum, Integer pageSize, Integer mode, Integer userId);

    int updateOrderData(Order order);

    int addOrderData(Order order);

    int delOrderData(Integer id);

    List<OrderStateCountDTO> getOrderCategory();
}
