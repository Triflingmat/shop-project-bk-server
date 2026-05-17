package com.project.shop.mapper;

import com.project.shop.entity.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("""
        <script>
            SELECT * FROM goods
            WHERE 1=1
            <if test="mode != null and mode != 0">
                AND category_id = #{mode}
            </if>
            <if test="name != null and name != ''">
                AND name LIKE CONCAT('%', #{name}, '%')
            </if>
            LIMIT #{offset}, #{pageSize}
        </script>
""")
    List<Goods> findGoodsData(Integer offset, Integer pageSize, Integer mode, String name);

    @Update("UPDATE `shop_project`.`goods` SET `name` = #{name}, `price` = #{price}, `is_on_sale` = #{is_on_sale}, `goods_img` = #{goods_img}, `category_id` = #{category_id}, `goods_desc` = #{goods_desc}, `stock` = #{stock} WHERE `id` = #{id}")
    int updateGoodsData(Goods goods);

    @Insert("INSERT INTO `shop_project`.`goods` (`name` , `price`, `is_on_sale`, `goods_img`, `category_id`, `goods_desc`, `stock`) VALUES (#{name}, #{price}, #{is_on_sale}, #{goods_img}, #{category_id}, #{goods_desc}, #{stock})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addGoodsData(Goods goods);

    @Delete("DELETE FROM `shop_project`.`goods` WHERE `id` = #{id}")
    int delGoodsData(Integer id);

    @Select("""
    <script>
        SELECT count(*) FROM goods
        WHERE 1=1
        <if test="mode != null and mode != 0">
            AND category_id = #{mode}
        </if>
        <if test="name != null and name != ''">
            AND name LIKE CONCAT('%', #{name}, '%')
        </if>
    </script>
""")
    long getGoodsCount(Integer mode, String name);

    @Select("SELECT * FROM goods WHERE id = #{id}")
    Goods getGoodsById(Integer id);

}
