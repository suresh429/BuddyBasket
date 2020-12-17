package com.buddy.basket.model;

public class PlaceOrderResponse {

    /**
     * customer_id : 5
     * total_amt : 116.00
     * customer_comments : null
     * updated_at : 2020-12-17T11:43:47.000000Z
     * created_at : 2020-12-17T11:43:47.000000Z
     * id : 3
     */

    private OrderBean order;
    /**
     * order_id : 3
     * item_id : 8
     * qty : 3
     * price : 58.00
     * updated_at : 2020-12-17T11:43:47.000000Z
     * created_at : 2020-12-17T11:43:47.000000Z
     * id : 3
     */

    private ItemsBean items;
    /**
     * order : {"customer_id":"5","total_amt":"116.00","customer_comments":null,"updated_at":"2020-12-17T11:43:47.000000Z","created_at":"2020-12-17T11:43:47.000000Z","id":3}
     * items : {"order_id":3,"item_id":"8","qty":"3","price":"58.00","updated_at":"2020-12-17T11:43:47.000000Z","created_at":"2020-12-17T11:43:47.000000Z","id":3}
     * status : true
     * msg : Order was placed
     */

    private String status;
    private String msg;

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public ItemsBean getItems() {
        return items;
    }

    public void setItems(ItemsBean items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class OrderBean {
        private String customer_id;
        private String total_amt;
        private Object customer_comments;
        private String updated_at;
        private String created_at;
        private int id;

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

        public Object getCustomer_comments() {
            return customer_comments;
        }

        public void setCustomer_comments(Object customer_comments) {
            this.customer_comments = customer_comments;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class ItemsBean {
        private int order_id;
        private String item_id;
        private String qty;
        private String price;
        private String updated_at;
        private String created_at;
        private int id;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
