package com.project.shop.service;

import com.project.shop.entity.pojo.Cart;

import java.util.List;

public interface CartService {
    /** 获取用户购物车 */
    List<Cart> getCartList(Integer userId);

    /** 加入购物车（已存在则增加数量） */
    void addToCart(Integer userId, Cart cart);

    /** 更新购物车项（数量/选中状态） */
    void updateCartItem(Cart cart);

    /** 全选/全不选 */
    void updateAllChecked(Integer userId, Integer checked);

    /** 删除单个商品 */
    void removeCartItem(Integer id);

    /** 删除已选中商品 */
    void removeCheckedItems(Integer userId);

    /** 清空购物车 */
    void clearCart(Integer userId);
}
