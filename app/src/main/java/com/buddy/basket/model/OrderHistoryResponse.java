package com.buddy.basket.model;

import java.util.List;

public class OrderHistoryResponse {


    /**
     * orders : [{"id":1,"customer_id":"5","total_amt":"116.00","address_id":"4","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-13T15:41:37.000000Z","updated_at":"2020-12-13T15:41:37.000000Z","order_item":[{"id":1,"order_id":"1","item_id":"8","qty":"1","price":"58.00","created_at":"2020-12-13T15:41:37.000000Z","updated_at":"2020-12-13T15:41:37.000000Z","item":{"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}}],"address":{"id":4,"customer_id":"5","addr1":"test","addr2":"test","pincode":"500072","landmark":"test","updated_at":"2020-12-13T15:35:48.000000Z","created_at":"2020-12-13T15:35:48.000000Z"}},{"id":2,"customer_id":"5","total_amt":"116.00","address_id":"5","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-13T16:05:58.000000Z","updated_at":"2020-12-13T16:05:58.000000Z","order_item":[{"id":2,"order_id":"2","item_id":"8","qty":"3","price":"58.00","created_at":"2020-12-13T16:05:58.000000Z","updated_at":"2020-12-13T16:05:58.000000Z","item":{"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}}],"address":{"id":5,"customer_id":"5","addr1":"test","addr2":"test","pincode":"500072","landmark":"test","updated_at":"2020-12-13T16:01:22.000000Z","created_at":"2020-12-13T16:01:22.000000Z"}},{"id":3,"customer_id":"5","total_amt":"116.00","address_id":"6","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-17T11:43:47.000000Z","updated_at":"2020-12-17T11:43:47.000000Z","order_item":[{"id":3,"order_id":"3","item_id":"8","qty":"3","price":"58.00","created_at":"2020-12-17T11:43:47.000000Z","updated_at":"2020-12-17T11:43:47.000000Z","item":{"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}}],"address":{"id":6,"customer_id":"5","addr1":"test","addr2":"test","pincode":"500072","landmark":"test","updated_at":"2020-12-17T11:47:46.000000Z","created_at":"2020-12-17T11:47:46.000000Z"}},{"id":4,"customer_id":"5","total_amt":"116.00","address_id":"4","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-17T11:45:46.000000Z","updated_at":"2020-12-17T11:45:46.000000Z","order_item":[{"id":4,"order_id":"4","item_id":"8","qty":"3","price":"58.00","created_at":"2020-12-17T11:45:46.000000Z","updated_at":"2020-12-17T11:45:46.000000Z","item":{"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}}],"address":{"id":4,"customer_id":"5","addr1":"test","addr2":"test","pincode":"500072","landmark":"test","updated_at":"2020-12-13T15:35:48.000000Z","created_at":"2020-12-13T15:35:48.000000Z"}},{"id":5,"customer_id":"5","total_amt":"116.00","address_id":"1","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-19T14:41:05.000000Z","updated_at":"2020-12-19T14:41:05.000000Z","order_item":[{"id":5,"order_id":"5","item_id":"8","qty":"1","price":"58.00","created_at":"2020-12-19T14:41:05.000000Z","updated_at":"2020-12-19T14:41:05.000000Z","item":{"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}}],"address":null}]
     * status : true
     */

    private String status;
    /**
     * id : 1
     * customer_id : 5
     * total_amt : 116.00
     * address_id : 4
     * customer_comments : null
     * status : new
     * comments : null
     * created_at : 2020-12-13T15:41:37.000000Z
     * updated_at : 2020-12-13T15:41:37.000000Z
     * order_item : [{"id":1,"order_id":"1","item_id":"8","qty":"1","price":"58.00","created_at":"2020-12-13T15:41:37.000000Z","updated_at":"2020-12-13T15:41:37.000000Z","item":{"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}}]
     * address : {"id":4,"customer_id":"5","addr1":"test","addr2":"test","pincode":"500072","landmark":"test","updated_at":"2020-12-13T15:35:48.000000Z","created_at":"2020-12-13T15:35:48.000000Z"}
     */

    private List<OrdersBean> orders;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public static class OrdersBean {
        private int id;
        private String customer_id;
        private String total_amt;
        private String address_id;
        private Object customer_comments;
        private String status;
        private Object comments;
        private String created_at;
        private String updated_at;
        /**
         * id : 4
         * customer_id : 5
         * addr1 : test
         * addr2 : test
         * pincode : 500072
         * landmark : test
         * updated_at : 2020-12-13T15:35:48.000000Z
         * created_at : 2020-12-13T15:35:48.000000Z
         */

        private AddressBean address;
        /**
         * id : 1
         * order_id : 1
         * item_id : 8
         * qty : 1
         * price : 58.00
         * created_at : 2020-12-13T15:41:37.000000Z
         * updated_at : 2020-12-13T15:41:37.000000Z
         * item : {"id":8,"itemname":"Lays","slug":"lays","qty":"10","shop_id":"4","category_id":"18","subcategory_id":"11","price":"58.00","description":"Chips","choices":"veg","image":"storage/items/lays_20201127140933.jpg","status":"1","created_at":"2020-11-27T14:09:33.000000Z","updated_at":"2020-12-19T14:08:20.000000Z"}
         */

        private List<OrderItemBean> order_item;

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

        public String getTotal_amt() {
            return total_amt;
        }

        public void setTotal_amt(String total_amt) {
            this.total_amt = total_amt;
        }

        public String getAddress_id() {
            return address_id;
        }

        public void setAddress_id(String address_id) {
            this.address_id = address_id;
        }

        public Object getCustomer_comments() {
            return customer_comments;
        }

        public void setCustomer_comments(Object customer_comments) {
            this.customer_comments = customer_comments;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getComments() {
            return comments;
        }

        public void setComments(Object comments) {
            this.comments = comments;
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

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public List<OrderItemBean> getOrder_item() {
            return order_item;
        }

        public void setOrder_item(List<OrderItemBean> order_item) {
            this.order_item = order_item;
        }

        public static class AddressBean {
            private int id;
            private String customer_id;
            private String addr1;
            private String addr2;
            private String pincode;
            private String landmark;
            private String updated_at;
            private String created_at;

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

            public String getAddr1() {
                return addr1;
            }

            public void setAddr1(String addr1) {
                this.addr1 = addr1;
            }

            public String getAddr2() {
                return addr2;
            }

            public void setAddr2(String addr2) {
                this.addr2 = addr2;
            }

            public String getPincode() {
                return pincode;
            }

            public void setPincode(String pincode) {
                this.pincode = pincode;
            }

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }
        }

        public static class OrderItemBean {
            private int id;
            private String order_id;
            private String item_id;
            private String qty;
            private String price;
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

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
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
}
