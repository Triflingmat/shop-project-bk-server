package com.project.shop.service.impl;

import com.project.shop.entity.pojo.AfterSales;
import com.project.shop.entity.pojo.Page;
import com.project.shop.mapper.AfterSalesMapper;
import com.project.shop.service.AfterSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AfterSalesServiceImpl implements AfterSalesService {

    @Autowired
    private AfterSalesMapper afterSalesMapper;

    public Page findAfterSalesData(Integer pageNum, Integer pageSize, Integer type, Integer status){
        int offset = (pageNum - 1) * pageSize;
        List<AfterSales> list = afterSalesMapper.findAfterSalesData(offset,pageSize,type,status);
        long total = afterSalesMapper.getAfterSalesCount(type,status);
        Page<AfterSales> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setList(list);
        page.setTotal(total);
        return page;
    }

    public int  updateAfterSalesData(AfterSales afterSales){
        return afterSalesMapper.updateAfterSalesData(afterSales);
    }

}
