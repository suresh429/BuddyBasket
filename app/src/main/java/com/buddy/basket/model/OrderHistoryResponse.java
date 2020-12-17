package com.buddy.basket.model;

import java.util.List;

public class OrderHistoryResponse {

    /**
     * orders : [{"id":1,"customer_id":"5","total_amt":"116.00","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-13T15:41:37.000000Z","updated_at":"2020-12-13T15:41:37.000000Z"},{"id":2,"customer_id":"5","total_amt":"116.00","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-13T16:05:58.000000Z","updated_at":"2020-12-13T16:05:58.000000Z"},{"id":3,"customer_id":"5","total_amt":"116.00","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-17T11:43:47.000000Z","updated_at":"2020-12-17T11:43:47.000000Z"},{"id":4,"customer_id":"5","total_amt":"116.00","customer_comments":null,"status":"new","comments":null,"created_at":"2020-12-17T11:45:46.000000Z","updated_at":"2020-12-17T11:45:46.000000Z"}]
     * status : true
     */

    private String status;
    /**
     * id : 1
     * customer_id : 5
     * total_amt : 116.00
     * customer_comments : null
     * status : new
     * comments : null
     * created_at : 2020-12-13T15:41:37.000000Z
     * updated_at : 2020-12-13T15:41:37.000000Z
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
        private Object customer_comments;
        private String status;
        private Object comments;
        private String created_at;
        private String updated_at;

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
    }
}
