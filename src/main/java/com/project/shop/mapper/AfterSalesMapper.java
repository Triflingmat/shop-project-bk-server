package com.project.shop.mapper;


import com.project.shop.entity.pojo.AfterSales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Update("UPDATE `shop_project`.`after_sales` SET `id` = #{id},`order_id` = #{order_id},`goods_name` = #{goods_name},`type` = #{type},`status` = #{status},`refund_price` = #{refund_price},`reason` = #{reason},`admin_note` = #{admin_note},`creat_time` = #{creat_time}")
    int updateAfterSalesData(AfterSales afterSales);

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
}
