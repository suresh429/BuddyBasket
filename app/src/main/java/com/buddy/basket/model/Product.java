package com.buddy.basket.model;

public class Product {

    private String id;
    private String pdtName;
    private String category;
    private String type;
    private String image;
    private Double price;
    private int Qty;

    public Product(String id, String pdtName, String category, String type, String image, Double price, int qty) {
        this.id = id;
        this.pdtName = pdtName;
        this.category = category;
        this.type = type;
        this.image = image;
        this.price = price;
        Qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPdtName() {
        return pdtName;
    }

    public void setPdtName(String pdtName) {
        this.pdtName = pdtName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }
}
