package com.rajendra.onlinedailygroceries.model;

import java.io.Serializable;

public class ProductDetail implements Serializable {

    int id;

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", view=" + view +
                ", status='" + status + '\'' +
                ", stt='" + stt + '\'' +
                ", details='" + details + '\'' +
                ", specifications='" + specifications + '\'' +
                '}';
    }

    String name;
    int price;
    int quantity;
    String image;
    String description;
    String tag;
    int view;
    String status;
    String stt;
    String details;
    String specifications;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public ProductDetail(int id, String name, int price, int quantity, String image, String description, String tag, int view, String status, String stt, String details, String specifications) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.tag = tag;
        this.view = view;
        this.status = status;
        this.stt = stt;
        this.details = details;
        this.specifications = specifications;
    }
}
