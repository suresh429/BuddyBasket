package com.buddy.basket.model;

import java.util.List;

public class RestaurantListResponse {


    /**
     * status : true
     * data : [{"Restaurant_ID":"5f4525abd4c85","Type":"All Restaurants","RestaurantLogo":"http://starvelater.ml/uploads/subayya.jpg","Restaurant_Name":"Subayya Hotel","KnownFor":"Best Vegetarian Dishes...","Address":"Ramanayyapeta, Near Raja Tank","OperationStatus":"Closed","AvgPrepTime":"45 mins"},{"Restaurant_ID":"5f455317543a3","Type":"Most Popular","RestaurantLogo":"http://starvelater.ml/uploads/bawarchi.jpg","Restaurant_Name":"Bawarchi","KnownFor":"North Indian, Chinese, Seafood","Address":"Nallakunta","OperationStatus":"Open","AvgPrepTime":"0"},{"Restaurant_ID":"5f4554ee53378","Type":"Most Popular","RestaurantLogo":"http://starvelater.ml/uploads/Red Chillies.jfif","Restaurant_Name":"Red Chillies Restaurant","KnownFor":"Indian, Chinese","Address":"NAD Junction","OperationStatus":"Open","AvgPrepTime":"0"},{"Restaurant_ID":"5f4559044e64d","Type":"Most Popular","RestaurantLogo":"http://starvelater.ml/uploads/creamstone.jfif","Restaurant_Name":"Cream Stone Ice Cream","KnownFor":"Desserts, Ice Cream","Address":"Somajiguda","OperationStatus":"Open","AvgPrepTime":"0 mins"}]
     */

    private boolean status;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Restaurant_ID : 5f4525abd4c85
         * Type : All Restaurants
         * RestaurantLogo : http://starvelater.ml/uploads/subayya.jpg
         * Restaurant_Name : Subayya Hotel
         * KnownFor : Best Vegetarian Dishes...
         * Address : Ramanayyapeta, Near Raja Tank
         * OperationStatus : Closed
         * AvgPrepTime : 45 mins
         */

        private String Restaurant_ID;
        private String Type;
        private String RestaurantLogo;
        private String Restaurant_Name;
        private String KnownFor;
        private String Address;
        private String OperationStatus;
        private String AvgPrepTime;

        public String getRestaurant_ID() {
            return Restaurant_ID;
        }

        public void setRestaurant_ID(String Restaurant_ID) {
            this.Restaurant_ID = Restaurant_ID;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getRestaurantLogo() {
            return RestaurantLogo;
        }

        public void setRestaurantLogo(String RestaurantLogo) {
            this.RestaurantLogo = RestaurantLogo;
        }

        public String getRestaurant_Name() {
            return Restaurant_Name;
        }

        public void setRestaurant_Name(String Restaurant_Name) {
            this.Restaurant_Name = Restaurant_Name;
        }

        public String getKnownFor() {
            return KnownFor;
        }

        public void setKnownFor(String KnownFor) {
            this.KnownFor = KnownFor;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getOperationStatus() {
            return OperationStatus;
        }

        public void setOperationStatus(String OperationStatus) {
            this.OperationStatus = OperationStatus;
        }

        public String getAvgPrepTime() {
            return AvgPrepTime;
        }

        public void setAvgPrepTime(String AvgPrepTime) {
            this.AvgPrepTime = AvgPrepTime;
        }
    }
}
