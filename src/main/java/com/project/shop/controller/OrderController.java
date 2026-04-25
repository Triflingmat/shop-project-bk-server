package com.project.shop.controller;


import com.project.shop.common.Result;
import com.project.shop.entity.dto.OrderStateCountDTO;
import com.project.shop.entity.pojo.Order;
import com.project.shop.entity.pojo.Page;
import com.project.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    
    //更改用户数据
    @PutMapping("/order/update")
    public Result<Order> updateOrderData(@RequestBody Order order){
        int updateOrder = orderService.updateOrderData(order);
        if (updateOrder==0){
            return Result.fail("发生错误");
        }
        return Result.success(order);
    }
    //增加用户数据
    @PostMapping("/order/add")
    public  Result<Order> addOrderData(@RequestBody Order order){
        int addOrder = orderService.addOrderData(order);
        if (addOrder==0){
            return Result.fail("发生错误");
        }
        return Result.success(order);
    }

    //删除用户数据
    @DeleteMapping("/order/del/{id}")
    public  Result<Order> delOrderData(@PathVariable Integer id){
        int delOrder = orderService.delOrderData(id);
        if (delOrder==0){
            return Result.fail("发生错误");
        }
        return Result.success(null);
    }
    
    

}
