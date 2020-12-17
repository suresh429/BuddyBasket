package com.buddy.basket.model;

import java.util.List;

public class AddressResponse {

    /**
     * addresses : [{"id":4,"customer_id":"5","addr1":"test","addr2":"test","pincode":"500072","landmark":"test","updated_at":"2020-12-13T15:35:48.000000Z","created_at":"2020-12-13T15:35:48.000000Z"},{"id":5,"customer_id":"5","addr1":"test","addr2":"test","pincode":"500072","landmark":"test","updated_at":"2020-12-13T16:01:22.000000Z","created_at":"2020-12-13T16:01:22.000000Z"}]
     * status : true
     */

    private String status;
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

    private List<AddressesBean> addresses;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AddressesBean> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressesBean> addresses) {
        this.addresses = addresses;
    }

    public static class AddressesBean {
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
}
