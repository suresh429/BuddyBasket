package com.buddy.basket.model;

import java.util.List;

public class ShopsListResponse {


    /**
     * data : [{"id":5,"shopname":"Vishal Mart","slug":"vishal-mart","description":"General Store - Available at various locations across India","state_id":"1","city_id":"2","category_id":"18","address":"Kurmannapalem","phone":"9052952930","website":null,"opentime":"10:00 A.M","closetime":"10:00 P.M","image":"storage/shops/vishal-mart_20201127132224.jpg","status":"1","created_at":"2020-11-27T13:22:09.000000Z","updated_at":"2020-11-28T05:56:08.000000Z","city":{"id":2,"city":"Visakhapatnam","slug":"visakhapatnam","status":"1","state_id":"1","created_at":"2020-11-19T21:27:32.000000Z","updated_at":"2020-11-19T21:27:32.000000Z"}},{"id":6,"shopname":"Ratnadeep Super Market","slug":"ratnadeep-super-market","description":"First Class Supermarket","state_id":"1","city_id":"2","category_id":"18","address":"Gajuwaka","phone":"9490677878","website":null,"opentime":"10:00 A.M","closetime":"10:00 P.M","image":"storage/shops/ratnadeep-super-market_20201127132530.jpg","status":"1","created_at":"2020-11-27T13:25:30.000000Z","updated_at":"2020-11-28T05:56:14.000000Z","city":{"id":2,"city":"Visakhapatnam","slug":"visakhapatnam","status":"1","state_id":"1","created_at":"2020-11-19T21:27:32.000000Z","updated_at":"2020-11-19T21:27:32.000000Z"}}]
     * status : true
     */

    private String status;
    /**
     * id : 5
     * shopname : Vishal Mart
     * slug : vishal-mart
     * description : General Store - Available at various locations across India
     * state_id : 1
     * city_id : 2
     * category_id : 18
     * address : Kurmannapalem
     * phone : 9052952930
     * website : null
     * opentime : 10:00 A.M
     * closetime : 10:00 P.M
     * image : storage/shops/vishal-mart_20201127132224.jpg
     * status : 1
     * created_at : 2020-11-27T13:22:09.000000Z
     * updated_at : 2020-11-28T05:56:08.000000Z
     * city : {"id":2,"city":"Visakhapatnam","slug":"visakhapatnam","status":"1","state_id":"1","created_at":"2020-11-19T21:27:32.000000Z","updated_at":"2020-11-19T21:27:32.000000Z"}
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
        private String shopname;
        private String slug;
        private String description;
        private String state_id;
        private String city_id;
        private String category_id;
        private String address;
        private String phone;
        private Object website;
        private String opentime;
        private String closetime;
        private String image;
        private String status;
        private String created_at;
        private String updated_at;
        /**
         * id : 2
         * city : Visakhapatnam
         * slug : visakhapatnam
         * status : 1
         * state_id : 1
         * created_at : 2020-11-19T21:27:32.000000Z
         * updated_at : 2020-11-19T21:27:32.000000Z
         */

        private CityBean city;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getState_id() {
            return state_id;
        }

        public void setState_id(String state_id) {
            this.state_id = state_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getWebsite() {
            return website;
        }

        public void setWebsite(Object website) {
            this.website = website;
        }

        public String getOpentime() {
            return opentime;
        }

        public void setOpentime(String opentime) {
            this.opentime = opentime;
        }

        public String getClosetime() {
            return closetime;
        }

        public void setClosetime(String closetime) {
            this.closetime = closetime;
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

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public static class CityBean {
            private int id;
            private String city;
            private String slug;
            private String status;
            private String state_id;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getState_id() {
                return state_id;
            }

            public void setState_id(String state_id) {
                this.state_id = state_id;
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
