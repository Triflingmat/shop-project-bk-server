package com.project.shop.controller;


import com.project.shop.common.Result;
import com.project.shop.entity.pojo.AfterSales;
import com.project.shop.entity.pojo.Page;
import com.project.shop.service.AfterSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AfterSalesController {

    @Autowired
    private AfterSalesService afterSalesService;

    //查找数据
    @GetMapping("/aftersales/list")
    public Result<Page<AfterSales>> findAfterSalesData(
            @RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "15")Integer pageSize,
            @RequestParam(defaultValue = "0") Integer type,
            @RequestParam(defaultValue = "0") Integer status
    ){
        try{
            Page<AfterSales> page = afterSalesService.findAfterSalesData(pageNum,pageSize,type,status);
            return Result.success(page);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }

    @PutMapping("/aftersales/update")
    public Result<AfterSales> updateAfterSalesData(@RequestBody AfterSales afterSales){
        int updateAfterSales = afterSalesService.updateAfterSalesData(afterSales);
        if(updateAfterSales == 0){
            return Result.fail("发生错误");
        }
        return Result.success(afterSales);
    }


}
