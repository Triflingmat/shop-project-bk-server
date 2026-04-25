package com.project.shop.entity.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AfterSales {
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

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getRefund_price() {
        return refund_price;
    }

    public void setRefund_price(BigDecimal refund_price) {
        this.refund_price = refund_price;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAdmin_note() {
        return admin_note;
    }

    public void setAdmin_note(String admin_note) {
        this.admin_note = admin_note;
    }

    public LocalDateTime getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(LocalDateTime creat_time) {
        this.creat_time = creat_time;
    }

    Integer id;
    Integer order_id;
    String goods_name;
    Integer type;
    Integer status;
    BigDecimal refund_price;
    String reason;
    String admin_note;
    LocalDateTime creat_time;

    public AfterSales(Integer id, Integer order_id, String goods_name, Integer type, Integer status, BigDecimal refund_price, String reason, String admin_note, LocalDateTime creat_time) {
        this.id = id;
        this.order_id = order_id;
        this.goods_name = goods_name;
        this.type = type;
        this.status = status;
        this.refund_price = refund_price;
        this.reason = reason;
        this.admin_note = admin_note;
        this.creat_time = creat_time;
    }
}
