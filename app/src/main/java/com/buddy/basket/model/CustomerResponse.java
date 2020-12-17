package com.buddy.basket.model;

import androidx.databinding.BaseObservable;

import java.util.List;

public class CustomerResponse {


    /**
     * customer : [{"id":6,"phonenumber":"903080894","name":"test","password":"123456","created_at":"2020-12-13T15:57:34.000000Z","updated_at":"2020-12-13T15:57:34.000000Z"}]
     * status : true
     */

    private String status;
    /**
     * id : 6
     * phonenumber : 903080894
     * name : test
     * password : 123456
     * created_at : 2020-12-13T15:57:34.000000Z
     * updated_at : 2020-12-13T15:57:34.000000Z
     */

    private List<CustomerBean> customer;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CustomerBean> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerBean> customer) {
        this.customer = customer;
    }

    public static class CustomerBean {
        private int id;
        private String phonenumber;
        private String name;
        private String password;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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
