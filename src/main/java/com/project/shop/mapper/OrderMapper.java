package com.project.shop.mapper;

import com.project.shop.entity.dto.OrderStateCountDTO;
import com.project.shop.entity.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OrderMapper {

    @Select("""
        SELECT 
            case state
                WHEN 1 THEN '已取消'
                WHEN 2 THEN '已退款'
                WHEN 3 THEN '待支付'
                WHEN 4 THEN '待收货'
                WHEN 5 THEN '已完成'
                ELSE '未知状态'
            END As name,
        COUNT(*) AS value
        FROM `orders`
        GROUP BY state
""")
    List<OrderStateCountDTO> getOrderCategory();

    @Select("""
        <script>
            SELECT * FROM orders
            WHERE 1=1
            <if test="mode != null and mode != 0">
                AND state = #{mode}
            </if>
            LIMIT #{offset}, #{pageSize};
        </script>
""")
    List<Order> findOrderData(Integer offset, Integer pageSize, Integer mode);

    @Update("UPDATE `shop_project`.`orders` SET `user_id` = #{user_id}, `state` = #{state}, `username` = #{username}, `phone` = #{phone}, `address` = #{address}, `total_amount` = #{total_amount}, `remark` = #{remark}, `create_time` = #{create_time} WHERE `id` = #{id}")
    int updateOrderData(Order order);

    @Insert("INSERT INTO `shop_project`.`orders` (`user_id` , `state`, `username`, `phone`, `address`, `total_amount`, `remark`, `create_time`) VALUES (#{user_id}, #{state}, #{username}, #{phone}, #{address}, #{total_amount}, #{remark}, #{create_time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addOrderData(Order order);

    @Delete("DELETE FROM `shop_project`.`orders` WHERE `id` = #{id}")
    int delOrderData(Integer id);

    @Select("""
    <script>
        SELECT count(*) FROM orders
        WHERE 1=1
        <if test="mode != null and mode != 0">
            AND state = #{mode}
        </if>
    </script>
""")
    long getOrderCount(Integer mode);
}
