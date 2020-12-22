package com.buddy.basket.model;

public class ItemDetailsResponse {

    private int id;
    private String itemname;
    private String slug;
    private int qty;
    private String shop_id;
    private String category_id;
    private String subcategory_id;
    private Double price;
    private String description;
    private String choices;
    private String image;
    private String status;
    private String created_at;
    private String updated_at;

    public ItemDetailsResponse(int id, String itemname, String slug, int qty, String shop_id, String category_id, String subcategory_id, Double price, String description, String choices, String image, String status, String created_at, String updated_at) {
        this.id = id;
        this.itemname = itemname;
        this.slug = slug;
        this.qty = qty;
        this.shop_id = shop_id;
        this.category_id = category_id;
        this.subcategory_id = subcategory_id;
        this.price = price;
        this.description = description;
        this.choices = choices;
        this.image = image;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(String subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
