package com.project.shop.service;

import com.project.shop.entity.dto.CategoryDto;
import com.project.shop.entity.pojo.Page;
import com.project.shop.entity.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategory();
    Page findCategoryData(Integer pageNum, Integer pageSize);
    int updateCategoryData(Category category);
    int addCategoryData(Category category);
    int delCategoryData(Integer id);
}