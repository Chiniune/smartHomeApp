package com.rajendra.onlinedailygroceries.model;

public class AllProducts {

    int productid;
    String productName;
    String status;
    float productPrice;
    int sold;
    int imageUrl;

    public AllProducts(int productid, String productName, String status, float productPrice, int sold, int imageUrl) {
        this.productid = productid;
        this.productName = productName;
        this.status = status;
        this.productPrice = productPrice;
        this.sold = sold;
        this.imageUrl = imageUrl;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
