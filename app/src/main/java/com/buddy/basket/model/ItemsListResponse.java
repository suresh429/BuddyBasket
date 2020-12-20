package com.buddy.basket.model;

import java.util.List;

public class ItemsListResponse {


    /**
     * data : [{"id":11,"itemname":"Top Ramen","slug":"top-ramen","qty":"10","shop_id":"5","category_id":"18","subcategory_id":"13","price":"58.00","description":"Veg-Noodles","choices":"veg","image":"storage/items/top-ramen_20201127141936.jpg","status":"1","created_at":"2020-11-27T14:19:36.000000Z","updated_at":"2020-11-28T17:33:02.000000Z"},{"id":12,"itemname":"Maggi","slug":"maggi","qty":"10","shop_id":"5","category_id":"18","subcategory_id":"13","price":"80.00","description":"Veg Noodles","choices":"veg","image":"storage/items/maggi_20201127142141.jpg","status":"1","created_at":"2020-11-27T14:21:41.000000Z","updated_at":"2020-11-28T17:33:28.000000Z"},{"id":13,"itemname":"Britannia Biscuits","slug":"britannia-biscuits","qty":"10","shop_id":"5","category_id":"18","subcategory_id":"14","price":"40.00","description":"Crispy and Munchy Biscuits","choices":"veg","image":"storage/items/britannia-biscuits_20201127142553.jpg","status":"1","created_at":"2020-11-27T14:25:53.000000Z","updated_at":"2020-11-28T17:33:36.000000Z"}]
     * status : true
     */

    private String status;
    /**
     * id : 11
     * itemname : Top Ramen
     * slug : top-ramen
     * qty : 10
     * shop_id : 5
     * category_id : 18
     * subcategory_id : 13
     * price : 58.00
     * description : Veg-Noodles
     * choices : veg
     * image : storage/items/top-ramen_20201127141936.jpg
     * status : 1
     * created_at : 2020-11-27T14:19:36.000000Z
     * updated_at : 2020-11-28T17:33:02.000000Z
     */

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
        private int id;
        private String itemname;
        private String slug;
        private String qty;
        private String shop_id;
        private String category_id;
        private String subcategory_id;
        private String price;
        private String description;
        private String choices;
        private String image;
        private String status;
        private String created_at;
        private String updated_at;

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
}
