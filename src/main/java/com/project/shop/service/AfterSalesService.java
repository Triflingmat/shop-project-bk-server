package com.project.shop.service;


import com.project.shop.entity.pojo.AfterSales;
import com.project.shop.entity.pojo.Page;

public interface AfterSalesService {

    Page findAfterSalesData(Integer pageNum, Integer pageSize, Integer type, Integer status);

    /** 普通用户查看自己的售后 */
    Page findUserAfterSalesData(Integer pageNum, Integer pageSize, Integer type, Integer status, Integer userId);

    int updateAfterSalesData(AfterSales afterSales);

    int addAfterSalesData(AfterSales afterSales);
}
