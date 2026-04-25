package com.project.shop.service.impl;

import com.project.shop.entity.dto.CategoryDto;
import com.project.shop.entity.pojo.Category;
import com.project.shop.entity.pojo.Page;
import com.project.shop.mapper.CategoryMapper;
import com.project.shop.mapper.GoodsMapper;
import com.project.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public  List<CategoryDto> getCategory(){return categoryMapper.getCategory();}

    @Override
    public Page findCategoryData(Integer pageNum, Integer pageSize){
        int offset = (pageNum - 1) * pageSize;
        List<Category> list = categoryMapper.findCategoryData(offset,pageSize);
        long total = categoryMapper.getCategoryCount();
        Page<Category> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setList(list);
        page.setTotal(total);
        return page;
    }

    @Override
    public int updateCategoryData(Category category){
        return categoryMapper.updateCategoryData(category);
    }

    @Override
    public int addCategoryData(Category category){
        return categoryMapper.addCategoryData(category);
    }

    @Override
    public int delCategoryData(Integer id){
        return categoryMapper.delCategoryData(id);
    }
}