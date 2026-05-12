package com.project.shop.mapper;

import com.project.shop.entity.pojo.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("SELECT * FROM cart WHERE user_id = #{userId}")
    List<Cart> findByUserId(Integer userId);

    @Select("SELECT * FROM cart WHERE user_id = #{userId} AND goods_id = #{goodsId}")
    Cart findByUserAndGoods(Integer userId, Integer goodsId);

    @Insert("INSERT INTO `shop_project`.`cart` (`user_id`, `goods_id`, `goods_name`, `goods_img`, `price`, `quantity`, `checked`) VALUES (#{user_id}, #{goods_id}, #{goods_name}, #{goods_img}, #{price}, #{quantity}, #{checked})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Cart cart);

    @Update("UPDATE `shop_project`.`cart` SET `quantity` = #{quantity}, `checked` = #{checked} WHERE `id` = #{id}")
    int update(Cart cart);

    @Update("UPDATE `shop_project`.`cart` SET `checked` = #{checked} WHERE `user_id` = #{userId}")
    int updateAllChecked(Integer userId, Integer checked);

    @Delete("DELETE FROM `shop_project`.`cart` WHERE `id` = #{id}")
    int deleteById(Integer id);

    @Delete("DELETE FROM `shop_project`.`cart` WHERE `user_id` = #{userId} AND `checked` = 1")
    int deleteCheckedByUserId(Integer userId);

    @Delete("DELETE FROM `shop_project`.`cart` WHERE `user_id` = #{userId}")
    int deleteAllByUserId(Integer userId);
}
