package com.project.shop.entity.dto;

public class CategoryDto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public CategoryDto(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private  Integer value;
}
