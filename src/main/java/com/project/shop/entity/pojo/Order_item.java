package com.project.shop.entity.pojo;

import java.math.BigDecimal;

public class Order_item {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order_item(Integer id, Integer order_id, Integer goods_id, String goods_name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.price = price;
        this.quantity = quantity;
    }

    Integer id;
    Integer order_id;
    Integer goods_id;
    String goods_name;
    BigDecimal price;
    Integer quantity;
}
