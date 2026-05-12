package com.project.shop.controller;


import com.project.shop.common.Result;
import com.project.shop.entity.pojo.AfterSales;
import com.project.shop.entity.pojo.Page;
import com.project.shop.service.AfterSalesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

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

    /** 新增售后申请 */
    @PostMapping("/aftersales/add")
    public Result<AfterSales> addAfterSalesData(@RequestBody AfterSales afterSales, HttpServletRequest request){
        try {
            Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
            if (claims == null) {
                return Result.fail("未登录");
            }
            afterSales.setStatus(1); // 待审核
            afterSales.setCreat_time(LocalDateTime.now());
            int result = afterSalesService.addAfterSalesData(afterSales);
            if (result == 0) {
                return Result.fail("发生错误");
            }
            return Result.success(afterSales);
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }

    /** 当前用户自己的售后记录 */
    @GetMapping("/aftersales/myList")
    public Result<Page<AfterSales>> findMyAfterSalesData(
            @RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "15")Integer pageSize,
            @RequestParam(defaultValue = "0") Integer type,
            @RequestParam(defaultValue = "0") Integer status,
            HttpServletRequest request){
        try{
            Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
            Integer userId = (Integer) claims.get("id");
            Page<AfterSales> page = afterSalesService.findUserAfterSalesData(pageNum, pageSize, type, status, userId);
            return Result.success(page);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }
}
