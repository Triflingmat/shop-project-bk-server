package com.project.shop.controller;

import com.project.shop.common.Result;
import com.project.shop.entity.pojo.Cart;
import com.project.shop.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    /** 获取用户购物车 */
    @GetMapping("/cart/list")
    public Result<List<Cart>> getCartList(HttpServletRequest request) {
        try {
            Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
            Integer userId = (Integer) claims.get("id");
            List<Cart> list = cartService.getCartList(userId);
            return Result.success(list);
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }

    /** 加入购物车 */
    @PostMapping("/cart/add")
    public Result<String> addToCart(@RequestBody Cart cart, HttpServletRequest request) {
        try {
            Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
            Integer userId = (Integer) claims.get("id");
            cartService.addToCart(userId, cart);
            return Result.success("添加成功");
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }

    /** 更新购物车项（数量/选中状态） */
    @PutMapping("/cart/update")
    public Result<String> updateCartItem(@RequestBody Cart cart) {
        try {
            cartService.updateCartItem(cart);
            return Result.success("更新成功");
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }

    /** 全选/全不选 */
    @PutMapping("/cart/checkAll")
    public Result<String> checkAll(@RequestParam Integer checked, HttpServletRequest request) {
        try {
            Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
            Integer userId = (Integer) claims.get("id");
            cartService.updateAllChecked(userId, checked);
            return Result.success("操作成功");
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }

    /** 删除购物车项 */
    @DeleteMapping("/cart/del/{id}")
    public Result<String> deleteCartItem(@PathVariable Integer id) {
        try {
            cartService.removeCartItem(id);
            return Result.success("删除成功");
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }

    /** 删除已选中商品（下单后调用） */
    @DeleteMapping("/cart/clearChecked")
    public Result<String> clearChecked(HttpServletRequest request) {
        try {
            Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
            Integer userId = (Integer) claims.get("id");
            cartService.removeCheckedItems(userId);
            return Result.success("清除成功");
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }

    /** 清空购物车 */
    @DeleteMapping("/cart/clear")
    public Result<String> clearCart(HttpServletRequest request) {
        try {
            Map<String, Object> claims = (Map<String, Object>) request.getAttribute("claims");
            Integer userId = (Integer) claims.get("id");
            cartService.clearCart(userId);
            return Result.success("清空成功");
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }
}
