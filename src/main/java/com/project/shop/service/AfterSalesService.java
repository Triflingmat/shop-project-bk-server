package com.project.shop.service;


import com.project.shop.entity.pojo.AfterSales;
import com.project.shop.entity.pojo.Page;

public interface AfterSalesService {

    Page findAfterSalesData(Integer pageNum, Integer pageSize, Integer type, Integer status);


    int updateAfterSalesData(AfterSales afterSales);
}
