package com.buddy.basket.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemsListResponse {


    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("id")
        private int id;
        @SerializedName("itemname")
        private String itemname;
        @SerializedName("slug")
        private String slug;
        @SerializedName("qty")
        private String qty;
        @SerializedName("shop_id")
        private String shopId;
        @SerializedName("category_id")
        private String categoryId;
        @SerializedName("subcategory_id")
        private String subcategoryId;
        @SerializedName("price")
        private String price;
        @SerializedName("description")
        private String description;
        @SerializedName("choices")
        private String choices;
        @SerializedName("image")
        private String image;
        @SerializedName("status")
        private String status;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;


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

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
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

        public String getSubcategoryId() {
            return subcategoryId;
        }

        public void setSubcategoryId(String subcategoryId) {
            this.subcategoryId = subcategoryId;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
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

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }


    }
}
