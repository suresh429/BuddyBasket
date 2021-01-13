package com.buddy.basket.model;

public class CartModel {
    private int cartId ;
    private String customerId;
    private String itemId;
    private int cart_qty;
    private String itemName;
    private int total_qty;
    private double price;
    private String shopId;
    private String categoryId;
    private String subCategoryId;
    private String image;
    private String choice;
    private String status;
    private int deliveryCharge;

    public CartModel(int cartId, String customerId, String itemId, int cart_qty, String  itemName, int total_qty, double price, String shopId, String categoryId, String subCategoryId, String image, String choice, String status,int deliveryCharge) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.cart_qty = cart_qty;
        this.itemName = itemName;
        this.total_qty = total_qty;
        this.price = price;
        this.shopId = shopId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.image = image;
        this.choice = choice;
        this.status = status;
        this.deliveryCharge = deliveryCharge;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getCart_qty() {
        return cart_qty;
    }

    public void setCart_qty(int cart_qty) {
        this.cart_qty = cart_qty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getTotal_qty() {
        return total_qty;
    }

    public void setTotal_qty(int total_qty) {
        this.total_qty = total_qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }
}
