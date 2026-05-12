package com.project.shop.service.impl;

import com.project.shop.entity.pojo.Cart;
import com.project.shop.mapper.CartMapper;
import com.project.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> getCartList(Integer userId) {
        return cartMapper.findByUserId(userId);
    }

    @Override
    public void addToCart(Integer userId, Cart cart) {
        Cart exist = cartMapper.findByUserAndGoods(userId, cart.getGoods_id());
        if (exist != null) {
            // 已有则增加数量
            exist.setQuantity(exist.getQuantity() + cart.getQuantity());
            cartMapper.update(exist);
        } else {
            cart.setUser_id(userId);
            cart.setChecked(1); // 默认选中
            cartMapper.insert(cart);
        }
    }

    @Override
    public void updateCartItem(Cart cart) {
        cartMapper.update(cart);
    }

    @Override
    public void updateAllChecked(Integer userId, Integer checked) {
        cartMapper.updateAllChecked(userId, checked);
    }

    @Override
    public void removeCartItem(Integer id) {
        cartMapper.deleteById(id);
    }

    @Override
    public void removeCheckedItems(Integer userId) {
        cartMapper.deleteCheckedByUserId(userId);
    }

    @Override
    public void clearCart(Integer userId) {
        cartMapper.deleteAllByUserId(userId);
    }
}
