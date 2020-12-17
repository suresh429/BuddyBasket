package com.buddy.basket.model;

import java.util.List;

public class CitiesResponse {


    /**
     * data : [{"id":1,"city":"Hyderabad","slug":"hyderabad","status":"1","state_id":"2","created_at":"2020-11-15T03:42:16.000000Z","updated_at":"2020-11-29T14:10:22.000000Z"},{"id":2,"city":"Visakhapatnam","slug":"visakhapatnam","status":"1","state_id":"1","created_at":"2020-11-19T21:27:32.000000Z","updated_at":"2020-11-19T21:27:32.000000Z"},{"id":3,"city":"Vijiawada","slug":"vijiawada","status":"1","state_id":"1","created_at":"2020-11-19T21:27:40.000000Z","updated_at":"2020-11-19T21:27:40.000000Z"},{"id":4,"city":"Secunderabad","slug":"secunderabad","status":"1","state_id":"2","created_at":"2020-11-19T21:27:49.000000Z","updated_at":"2020-11-19T21:27:49.000000Z"},{"id":5,"city":"Warangal","slug":"warangal","status":"1","state_id":"2","created_at":"2020-11-19T21:27:57.000000Z","updated_at":"2020-11-19T21:27:57.000000Z"},{"id":6,"city":"Kakinada","slug":"kakinada","status":"1","state_id":"1","created_at":"2020-11-19T21:28:03.000000Z","updated_at":"2020-11-19T21:28:03.000000Z"},{"id":7,"city":"Rajahmundry","slug":"rajahmundry","status":"1","state_id":"1","created_at":"2020-11-19T21:28:10.000000Z","updated_at":"2020-11-19T21:28:10.000000Z"},{"id":8,"city":"Tirupathi","slug":"tirupathi","status":"1","state_id":"1","created_at":"2020-11-19T21:28:15.000000Z","updated_at":"2020-11-19T21:28:15.000000Z"},{"id":9,"city":"Adilabad","slug":"adilabad","status":"1","state_id":"2","created_at":"2020-11-19T21:28:23.000000Z","updated_at":"2020-11-19T21:28:23.000000Z"},{"id":10,"city":"Nalgonda","slug":"nalgonda","status":"1","state_id":"2","created_at":"2020-11-19T21:28:34.000000Z","updated_at":"2020-11-19T21:28:34.000000Z"}]
     * status : true
     */

    private String status;
    /**
     * id : 1
     * city : Hyderabad
     * slug : hyderabad
     * status : 1
     * state_id : 2
     * created_at : 2020-11-15T03:42:16.000000Z
     * updated_at : 2020-11-29T14:10:22.000000Z
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
