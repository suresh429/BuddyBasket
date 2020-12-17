package com.buddy.basket.model;

import java.util.List;

public class CategoriesResponse {


    /**
     * data : [{"id":17,"categoryname":"Food","slug":"food","image":"storage/categories/food_20201127130749.jpg","status":"1","created_at":"2020-11-27T13:07:49.000000Z","updated_at":"2020-11-29T06:31:42.000000Z"},{"id":18,"categoryname":"Groceries","slug":"groceries","image":"storage/categories/groceries_20201127130824.jpg","status":"1","created_at":"2020-11-27T13:08:24.000000Z","updated_at":"2020-11-27T13:08:24.000000Z"},{"id":19,"categoryname":"Sweets","slug":"sweets","image":"storage/categories/sweets_20201129070235.gif","status":"0","created_at":"2020-11-29T07:02:35.000000Z","updated_at":"2020-11-29T07:03:35.000000Z"}]
     * status : true
     */

    private String status;
    /**
     * id : 17
     * categoryname : Food
     * slug : food
     * image : storage/categories/food_20201127130749.jpg
     * status : 1
     * created_at : 2020-11-27T13:07:49.000000Z
     * updated_at : 2020-11-29T06:31:42.000000Z
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
        private String categoryname;
        private String slug;
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

        public String getCategoryname() {
            return categoryname;
        }

        public void setCategoryname(String categoryname) {
            this.categoryname = categoryname;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
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
