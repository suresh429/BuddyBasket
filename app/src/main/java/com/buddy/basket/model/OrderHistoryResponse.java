package com.buddy.basket.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderHistoryResponse {


    @SerializedName("status")
    private String status;
    @SerializedName("orders")
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
        @SerializedName("id")
        private int id;
        @SerializedName("customer_id")
        private String customerId;
        @SerializedName("total_amt")
        private String totalAmt;
        @SerializedName("address_id")
        private String addressId;
        @SerializedName("shop_id")
        private String shopId;
        @SerializedName("customer_comments")
        private Object customerComments;
        @SerializedName("status")
        private String status;
        @SerializedName("comments")
        private Object comments;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("address")
        private AddressBean address;
        @SerializedName("shop")
        private ShopBean shop;
        @SerializedName("order_item")
        private List<OrderItemBean> orderItem;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTotalAmt() {
            return totalAmt;
        }

        public void setTotalAmt(String totalAmt) {
            this.totalAmt = totalAmt;
        }

        public String getAddressId() {
            return addressId;
        }

        public void setAddressId(String addressId) {
            this.addressId = addressId;
        }

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
        }

        public Object getCustomerComments() {
            return customerComments;
        }

        public void setCustomerComments(Object customerComments) {
            this.customerComments = customerComments;
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

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
        }

        public List<OrderItemBean> getOrderItem() {
            return orderItem;
        }

        public void setOrderItem(List<OrderItemBean> orderItem) {
            this.orderItem = orderItem;
        }

        public static class AddressBean {
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
        }

        public static class ShopBean {
            @SerializedName("id")
            private int id;
            @SerializedName("shopname")
            private String shopname;
            @SerializedName("slug")
            private String slug;
            @SerializedName("description")
            private String description;
            @SerializedName("state_id")
            private String stateId;
            @SerializedName("city_id")
            private String cityId;
            @SerializedName("category_id")
            private String categoryId;
            @SerializedName("address")
            private String address;
            @SerializedName("phone")
            private String phone;
            @SerializedName("website")
            private Object website;
            @SerializedName("opentime")
            private String opentime;
            @SerializedName("closetime")
            private String closetime;
            @SerializedName("image")
            private String image;
            @SerializedName("status")
            private String status;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;

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

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
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

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }

        public static class OrderItemBean {
            @SerializedName("id")
            private int id;
            @SerializedName("order_id")
            private String orderId;
            @SerializedName("item_id")
            private String itemId;
            @SerializedName("shop_id")
            private String shopId;
            @SerializedName("qty")
            private String qty;
            @SerializedName("price")
            private String price;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;
            @SerializedName("item")
            private ItemBean item;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getItemId() {
                return itemId;
            }

            public void setItemId(String itemId) {
                this.itemId = itemId;
            }

            public String getShopId() {
                return shopId;
            }

            public void setShopId(String shopId) {
                this.shopId = shopId;
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

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public ItemBean getItem() {
                return item;
            }

            public void setItem(ItemBean item) {
                this.item = item;
            }

            public static class ItemBean {
                @SerializedName("id")
                private int id;
                @SerializedName("itemname")
                private String itemname;
                @SerializedName("slug")
                private String slug;
                @SerializedName("qty")
                private String qty;
                @SerializedName("shop_id")
                private String shopId;
                @SerializedName("category_id")
                private String categoryId;
                @SerializedName("subcategory_id")
                private String subcategoryId;
                @SerializedName("price")
                private String price;
                @SerializedName("description")
                private String description;
                @SerializedName("choices")
                private String choices;
                @SerializedName("image")
                private String image;
                @SerializedName("status")
                private String status;
                @SerializedName("created_at")
                private String createdAt;
                @SerializedName("updated_at")
                private String updatedAt;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getItemname() {
                    return itemname;
                }

                public void setItemname(String itemname) {
                    this.itemname = itemname;
                }

                public String getSlug() {
                    return slug;
                }

                public void setSlug(String slug) {
                    this.slug = slug;
                }

                public String getQty() {
                    return qty;
                }

                public void setQty(String qty) {
                    this.qty = qty;
                }

                public String getShopId() {
                    return shopId;
                }

                public void setShopId(String shopId) {
                    this.shopId = shopId;
                }

                public String getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(String categoryId) {
                    this.categoryId = categoryId;
                }

                public String getSubcategoryId() {
                    return subcategoryId;
                }

                public void setSubcategoryId(String subcategoryId) {
                    this.subcategoryId = subcategoryId;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getChoices() {
                    return choices;
                }

                public void setChoices(String choices) {
                    this.choices = choices;
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

                public String getCreatedAt() {
                    return createdAt;
                }

                public void setCreatedAt(String createdAt) {
                    this.createdAt = createdAt;
                }

                public String getUpdatedAt() {
                    return updatedAt;
                }

                public void setUpdatedAt(String updatedAt) {
                    this.updatedAt = updatedAt;
                }
            }
        }
    }
}
