package com.buddy.basket.model;

import java.util.List;

public class CartResponse {


    /**
     * cart : [{"id":5,"customer_id":"5","item_id":"8","qty":"1","created_at":"2020-12-20T13:32:53.000000Z","updated_at":"2020-12-20T13:32:53.000000Z","item":{"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}}]
     * status : true
     */

    private String status;
    /**
     * id : 5
     * customer_id : 5
     * item_id : 8
     * qty : 1
     * created_at : 2020-12-20T13:32:53.000000Z
     * updated_at : 2020-12-20T13:32:53.000000Z
     * item : {"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}
     */

    private List<CartBean> cart;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CartBean> getCart() {
        return cart;
    }

    public void setCart(List<CartBean> cart) {
        this.cart = cart;
    }

    public static class CartBean {
        private int id;
        private String customer_id;
        private String item_id;
        private String qty;
        private String created_at;
        private String updated_at;
        /**
         * id : 8
         * itemname : Lays
         * slug : lays
         * qty : 10
         * shop_id : 4
         * category_id : 18
         * subcategory_id : 11
         * price : 58.00
         * description : Chips
         * choices : veg
         * image : storage/items/lays_20201127140933.jpg
         * status : 1
         * created_at : 2020-11-27T14:09:33.000000Z
         * updated_at : 2020-12-19T14:08:20.000000Z
         */

        private ItemBean item;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getItem_id() {
            return item_id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
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

        public ItemBean getItem() {
            return item;
        }

        public void setItem(ItemBean item) {
            this.item = item;
        }

        public static class ItemBean {
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
}
