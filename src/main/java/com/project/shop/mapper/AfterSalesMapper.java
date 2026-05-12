package com.project.shop.mapper;


import com.project.shop.entity.pojo.AfterSales;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AfterSalesMapper {

    @Select("""
        <script>
            SELECT * FROM after_sales
            WHERE 1=1
        <if test="type != null and type != 0">
            AND type = #{type}
        </if>
        <if test="status != null and status != 0">
            AND status = #{status}
        </if>
            LIMIT #{offset}, #{pageSize}
        </script>
""")
    List<AfterSales> findAfterSalesData(Integer offset, Integer pageSize, Integer type, Integer status);

    @Update("UPDATE `shop_project`.`after_sales` SET `order_id` = #{order_id},`goods_name` = #{goods_name},`type` = #{type},`status` = #{status},`refund_price` = #{refund_price},`reason` = #{reason},`admin_note` = #{admin_note},`creat_time` = #{creat_time} WHERE `id` = #{id}")
    int updateAfterSalesData(AfterSales afterSales);

    @Insert("INSERT INTO `shop_project`.`after_sales` (`order_id`, `goods_name`, `type`, `status`, `refund_price`, `reason`, `admin_note`, `creat_time`) VALUES (#{order_id}, #{goods_name}, #{type}, #{status}, #{refund_price}, #{reason}, #{admin_note}, #{creat_time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addAfterSalesData(AfterSales afterSales);

    @Select("""
    <script>
        SELECT count(*) FROM after_sales
        WHERE 1=1
        <if test="type != null and type != 0">
            AND type = #{type}
        </if>
        <if test="status != null and status != 0">
            AND status = #{status}
        </if>
    </script>
""")
    long getAfterSalesCount(Integer type, Integer status);

    // === 按用户筛选（通过 order_id 关联 orders.user_id） ===
    @Select("""
        <script>
            SELECT a.* FROM after_sales a
            INNER JOIN orders o ON a.order_id = o.id
            WHERE o.user_id = #{userId}
            <if test="type != null and type != 0">
                AND a.type = #{type}
            </if>
            <if test="status != null and status != 0">
                AND a.status = #{status}
            </if>
            LIMIT #{offset}, #{pageSize}
        </script>
    """)
    List<AfterSales> findAfterSalesDataByUser(Integer offset, Integer pageSize, Integer type, Integer status, Integer userId);

    @Select("""
    <script>
        SELECT count(*) FROM after_sales a
        INNER JOIN orders o ON a.order_id = o.id
        WHERE o.user_id = #{userId}
        <if test="type != null and type != 0">
            AND a.type = #{type}
        </if>
        <if test="status != null and status != 0">
            AND a.status = #{status}
        </if>
    </script>
    """)
    long getAfterSalesCountByUser(Integer type, Integer status, Integer userId);
}
