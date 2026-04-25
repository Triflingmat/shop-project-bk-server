package com.project.shop.entity.pojo;

public class User {
    Integer id;
    String username;
    String password;
    Integer power;
    String phone;
    String address;
    String salt;

    public String getSalt(){return  salt;}
    public void setSalt(String salt){this.salt=salt;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPower() {
        return power;
    }

    public User(Integer id, String username, String password, Integer power,String phone,String address,String salt){
        this.id =id;
        this.username=username;
        this.password=password;
        this.power=power;
        this.phone =phone;
        this.address =address;
        this.salt = salt;
    }
}


