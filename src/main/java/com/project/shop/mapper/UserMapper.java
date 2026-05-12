package com.project.shop.mapper;

import com.project.shop.entity.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("""
        <script>
            SELECT * FROM user
            WHERE 1=1
            <if test="mode != null and mode != 0">
                AND power = #{mode}
            </if>
            LIMIT #{offset}, #{pageSize}
        </script>
""")
    List<User> findUserData(Integer offset, Integer pageSize, Integer mode);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Update("UPDATE `shop_project`.`user` SET `username` = #{username}, `password` = #{password}, `power` = #{power}, `phone` = #{phone}, `address` = #{address},`salt` = #{salt} WHERE `id` = #{id}")
    int updateUserData(User user);

    @Insert("INSERT INTO `shop_project`.`user` (`username` , `password`, `power`, `phone`, `address`,`salt`) VALUES (#{username}, #{password}, #{power}, #{phone}, #{address},#{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUserData(User user);

    @Delete("DELETE FROM `shop_project`.`user` WHERE `id` = #{id}")
    int delUserData(Integer id);

    @Select("SELECT count(*) FROM user WHERE power = #{mode}")
    long getUserCount(Integer mode);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);
}
