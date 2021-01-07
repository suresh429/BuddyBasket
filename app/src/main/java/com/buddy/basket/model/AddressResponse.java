package com.buddy.basket.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AddressResponse implements Serializable,Parcelable {


    @SerializedName("status")
    private String status;
    @SerializedName("addresses")
    private List<AddressesBean> addresses;

    protected AddressResponse(Parcel in) {
        status = in.readString();
        addresses = in.createTypedArrayList(AddressesBean.CREATOR);
    }

    public static final Creator<AddressResponse> CREATOR = new Creator<AddressResponse>() {
        @Override
        public AddressResponse createFromParcel(Parcel in) {
            return new AddressResponse(in);
        }

        @Override
        public AddressResponse[] newArray(int size) {
            return new AddressResponse[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeTypedList(addresses);
    }

    public static class AddressesBean implements Serializable, Parcelable {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("phone")
        private String phone;
        @SerializedName("customer_id")
        private String customerId;
        @SerializedName("addr1")
        private String addr1;
        @SerializedName("addr2")
        private String addr2;
        @SerializedName("pincode")
        private String pincode;
        @SerializedName("landmark")
        private String landmark;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("created_at")
        private String createdAt;

        protected AddressesBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
            phone = in.readString();
            customerId = in.readString();
            addr1 = in.readString();
            addr2 = in.readString();
            pincode = in.readString();
            landmark = in.readString();
            updatedAt = in.readString();
            createdAt = in.readString();
        }

        public static final Creator<AddressesBean> CREATOR = new Creator<AddressesBean>() {
            @Override
            public AddressesBean createFromParcel(Parcel in) {
                return new AddressesBean(in);
            }

            @Override
            public AddressesBean[] newArray(int size) {
                return new AddressesBean[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
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

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeString(phone);
            dest.writeString(customerId);
            dest.writeString(addr1);
            dest.writeString(addr2);
            dest.writeString(pincode);
            dest.writeString(landmark);
            dest.writeString(updatedAt);
            dest.writeString(createdAt);
        }
    }
}
