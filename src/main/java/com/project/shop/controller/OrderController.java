package com.project.shop.controller;


import com.project.shop.common.Result;
import com.project.shop.entity.dto.OrderStateCountDTO;
import com.project.shop.entity.pojo.Order;
import com.project.shop.entity.pojo.Page;
import com.project.shop.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/getCategory")
    public Result<List<OrderStateCountDTO>> getOrderCategory(){
        try{
            List<OrderStateCountDTO> getOrder_category = orderService.getOrderCategory();
            return Result.success(getOrder_category);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }

    //查找账单数据
    @GetMapping("/order/list")
    public Result<Page<Order>> findOrderData(
            @RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "15")Integer pageSize,
            @RequestParam(defaultValue = "0") Integer mode){
        try{
            Page<Order> page = orderService.findOrderData(pageNum,pageSize,mode);
            return Result.success(page);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }

    /** 当前用户自己的订单（按 userId 筛选） */
    @GetMapping("/order/myList")
    public Result<Page<Order>> findMyOrderData(
            @RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "15")Integer pageSize,
            @RequestParam(defaultValue = "0") Integer mode,
            HttpServletRequest request){
        try{
            Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
            Integer userId = (Integer) claims.get("id");
            Page<Order> page = orderService.findUserOrderData(pageNum, pageSize, mode, userId);
            return Result.success(page);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }
    
    //更改订单数据
    @PutMapping("/order/update")
    public Result<Order> updateOrderData(@RequestBody Order order){
        int updateOrder = orderService.updateOrderData(order);
        if (updateOrder==0){
            return Result.fail("发生错误");
        }
        return Result.success(order);
    }
    //增加订单（user_id 从 Token 获取，防止伪造）
    @PostMapping("/order/add")
    public Result<Order> addOrderData(@RequestBody Order order, HttpServletRequest request){
        // 从 Token 获取当前用户 ID，忽略请求体中的 user_id
        Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
        order.setUser_id((Integer) claims.get("id"));
        order.setCreate_time(LocalDateTime.now());

        int addOrder = orderService.addOrderData(order);
        if (addOrder==0){
            return Result.fail("发生错误");
        }
        return Result.success(order);
    }

    //删除订单数据
    @DeleteMapping("/order/del/{id}")
    public  Result<Order> delOrderData(@PathVariable Integer id){
        int delOrder = orderService.delOrderData(id);
        if (delOrder==0){
            return Result.fail("发生错误");
        }
        return Result.success(null);
    }
    
    

}
