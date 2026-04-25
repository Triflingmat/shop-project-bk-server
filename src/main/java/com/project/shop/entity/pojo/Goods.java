package com.project.shop.entity.pojo;

import java.math.BigDecimal;

public class Goods {
    public Goods(Integer id, String name, BigDecimal price, Integer is_on_sale, String goods_img, Integer category_id, String goods_desc, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.is_on_sale = is_on_sale;
        this.goods_img = goods_img;
        this.category_id = category_id;
        this.goods_desc = goods_desc;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getIs_on_sale() {
        return is_on_sale;
    }

    public void setIs_on_sale(Integer is_on_sale) {
        this.is_on_sale = is_on_sale;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    Integer id;
    String name;
    BigDecimal price;
    Integer is_on_sale;
    String goods_img;
    Integer category_id;
    String goods_desc;
    Integer stock;
}
