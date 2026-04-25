package com.project.shop.controller;

import com.project.shop.common.Result;
import com.project.shop.entity.dto.CategoryDto;
import com.project.shop.entity.pojo.Page;
import com.project.shop.entity.pojo.Category;
import com.project.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/getCategoryNameCount")
    public Result<List<CategoryDto>> getCategory(){
        try{
            List<CategoryDto> getCategoryData = categoryService.getCategory();
            return Result.success(getCategoryData);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }

    //查找分类数据
    @GetMapping("/category/list")
    public Result<Page<Category>> findCategoryData(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "15") Integer pageSize){
        try{
            Page<Category> page = categoryService.findCategoryData(pageNum,pageSize);
            return Result.success(page);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }

    //更改分类数据
    @PutMapping("/category/update")
    public Result<Category> updateCategoryData(@RequestBody Category category){
        int update = categoryService.updateCategoryData(category);
        if (update == 0){
            return Result.fail("发生错误");
        }
        return Result.success(category);
    }

    //增加分类数据
    @PostMapping("/category/add")
    public Result<Category> addCategoryData(@RequestBody Category category){
        int add = categoryService.addCategoryData(category);
        if (add == 0){
            return Result.fail("发生错误");
        }
        return Result.success(category);
    }

    //删除分类数据
    @DeleteMapping("/category/del/{id}")
    public Result<Category> delCategoryData(@PathVariable Integer id){
        int del = categoryService.delCategoryData(id);
        if (del == 0){
            return Result.fail("发生错误");
        }
        return Result.success(null);
    }
}