package com.project.shop.entity.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    public Order(Integer id, Integer user_id, Integer state, String username, String phone, String address, BigDecimal total_amount, String remark, LocalDateTime create_time) {
        this.id = id;
        this.user_id = user_id;
        this.state = state;
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.total_amount = total_amount;
        this.remark = remark;
        this.create_time = create_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    Integer id;
    Integer user_id;
    Integer state;
    String username;
    String phone;
    String address;
    BigDecimal total_amount;
    String remark;
    LocalDateTime create_time;
}
