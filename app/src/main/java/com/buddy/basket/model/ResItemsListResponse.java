package com.buddy.basket.model;

import java.util.List;

public class ResItemsListResponse {


    /**
     * status : true
     * Restaurant_Name : Cream Stone Ice Cream
     * data : [{"Category":"Choclate Wonders","Item_ID":"5f48ca94f3a6a","Item_Name":"Chocoholics","Type":"Vegetarian","Item_Price":"195","Availability":"Yes","Discount":"0 %","Final_Price":"195","imgUrl":"http://starvelater.ml/itemphotos/Cream Stone Ice Cream/chocoholics.jpg","Recommended":"No"},{"Category":"Fruit Wonders","Item_ID":"5f48cc0c26411","Item_Name":"Litchi Lake","Type":"Vegetarian","Item_Price":"170","Availability":"Yes","Discount":"0 %","Final_Price":"170","imgUrl":"http://starvelater.ml/itemphotos/Cream Stone Ice Cream/litchi lake.jpg","Recommended":"Yes"},{"Category":"Seasonal Star","Item_ID":"5f48cda136bc5","Item_Name":"Madagascar Scoop","Type":"Vegetarian","Item_Price":"90","Availability":"Yes","Discount":"0 %","Final_Price":"90","imgUrl":"http://starvelater.ml/itemphotos/Cream Stone Ice Cream/choclate Madagascar.jpg","Recommended":"No"}]
     */

    private boolean status;
    private String Restaurant_Name;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRestaurant_Name() {
        return Restaurant_Name;
    }

    public void setRestaurant_Name(String Restaurant_Name) {
        this.Restaurant_Name = Restaurant_Name;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Category : Choclate Wonders
         * Item_ID : 5f48ca94f3a6a
         * Item_Name : Chocoholics
         * Type : Vegetarian
         * Item_Price : 195
         * Availability : Yes
         * Discount : 0 %
         * Final_Price : 195
         * imgUrl : http://starvelater.ml/itemphotos/Cream Stone Ice Cream/chocoholics.jpg
         * Recommended : No
         */

        private String Category;
        private String Item_ID;
        private String Item_Name;
        private String Type;
        private String Item_Price;
        private String Availability;
        private String Discount;
        private String Final_Price;
        private String imgUrl;
        private String Recommended;

        public String getCategory() {
            return Category;
        }

        public void setCategory(String Category) {
            this.Category = Category;
        }

        public String getItem_ID() {
            return Item_ID;
        }

        public void setItem_ID(String Item_ID) {
            this.Item_ID = Item_ID;
        }

        public String getItem_Name() {
            return Item_Name;
        }

        public void setItem_Name(String Item_Name) {
            this.Item_Name = Item_Name;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getItem_Price() {
            return Item_Price;
        }

        public void setItem_Price(String Item_Price) {
            this.Item_Price = Item_Price;
        }

        public String getAvailability() {
            return Availability;
        }

        public void setAvailability(String Availability) {
            this.Availability = Availability;
        }

        public String getDiscount() {
            return Discount;
        }

        public void setDiscount(String Discount) {
            this.Discount = Discount;
        }

        public String getFinal_Price() {
            return Final_Price;
        }

        public void setFinal_Price(String Final_Price) {
            this.Final_Price = Final_Price;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getRecommended() {
            return Recommended;
        }

        public void setRecommended(String Recommended) {
            this.Recommended = Recommended;
        }
    }
}
