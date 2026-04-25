package com.project.shop.mapper;

import com.project.shop.entity.dto.CategoryDto;
import com.project.shop.entity.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT category.name,COUNT(goods.category_id) AS value FROM `category` LEFT JOIN `goods` ON category.id = goods.category_id GROUP BY category.id ")
    List<CategoryDto> getCategory();


    @Select("SELECT * FROM `category` LIMIT #{offset},#{pageSize}")
    List<Category> findCategoryData(Integer offset, Integer pageSize);

    @Update("UPDATE `shop_project`.`category` SET `name` = #{name} WHERE `id` = #{id}")
    int updateCategoryData(Category category);

    @Insert("INSERT INTO `shop_project`.`category` (`name`) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addCategoryData(Category category);

    @Delete("DELETE FROM `shop_project`.`category` WHERE `id` = #{id}")
    int delCategoryData(Integer id);

    @Select("SELECT count(*) FROM category")
    long getCategoryCount();
}