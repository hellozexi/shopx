package com.mikey.shopx.payload;

import javax.validation.constraints.NotBlank;

public class AddProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String category;
    @NotBlank
    private String manufacturer;
    @NotBlank
    private int price;
    @NotBlank
    private int unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
