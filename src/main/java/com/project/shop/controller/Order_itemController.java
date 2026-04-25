package com.project.shop.controller;

import com.project.shop.common.Result;
import com.project.shop.entity.pojo.Order_item;
import com.project.shop.service.Order_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class Order_itemController {

    @Autowired
    private Order_itemService order_itemService;

    @GetMapping("/order_item/getRevenue")
    public Result< BigDecimal> getRevenue(){
        try{
            BigDecimal revenue = order_itemService.getRevenue();
            return Result.success(revenue);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }

    //查找具体账单数据
    @GetMapping("/order_item/list/{id}")
    public Result<List<Order_item>> findOrder_itemData(@PathVariable Integer id){
        try{
            List<Order_item> order_itemList = order_itemService.findOrder_itemData(id);
            return Result.success(order_itemList);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }
    //更改具体账单数据
    @PutMapping("/order_item/update")
    public Result<Order_item> updateOrder_itemData(@RequestBody Order_item order_item){
        int updateOrder_item = order_itemService.updateOrder_itemData(order_item);
        if (updateOrder_item==0){
            return Result.fail("发生错误");
        }
        return Result.success(order_item);
    }
    //增加具体账单数据
    @PostMapping("/order_item/add")
    public  Result<Order_item> addOrder_itemData(@RequestBody Order_item order_item){
        int addOrder_item = order_itemService.addOrder_itemData(order_item);
        if (addOrder_item==0){
            return Result.fail("发生错误");
        }
        return Result.success(order_item);
    }

    //删除具体账单数据
    @DeleteMapping("/order_item/del/{id}")
    public  Result<Order_item> delOrder_itemData(@PathVariable Integer id){
        int delOrder_item = order_itemService.delOrder_itemData(id);
        if (delOrder_item==0){
            return Result.fail("发生错误");
        }
        return Result.success(null);
    }
}
