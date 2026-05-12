package com.project.shop.entity.pojo;

/**
 * 购物车实体
 */
public class Cart {
    private Integer id;
    private Integer user_id;
    private Integer goods_id;
    private String goods_name;
    private String goods_img;
    private String price;
    private Integer quantity;
    private Integer checked;  // 0=未选中, 1=已选中

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public Integer getGoods_id() { return goods_id; }
    public void setGoods_id(Integer goods_id) { this.goods_id = goods_id; }

    public String getGoods_name() { return goods_name; }
    public void setGoods_name(String goods_name) { this.goods_name = goods_name; }

    public String getGoods_img() { return goods_img; }
    public void setGoods_img(String goods_img) { this.goods_img = goods_img; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Integer getChecked() { return checked; }
    public void setChecked(Integer checked) { this.checked = checked; }
}
