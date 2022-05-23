package com.rajendra.onlinedailygroceries.model;

import java.io.Serializable;

public class BlogDetail  implements Serializable {

    int idblog;
    String title;
    String author;
    String content;
    String date;
    String image;
    String tag;
    int status;
    String ct1;
    String ct2;
    String ct3;
    String image1;
    String image2;

    public BlogDetail(int idblog, String title, String author, String content, String date, String image, String tag, int status, String ct1, String ct2, String ct3, String image1, String image2) {
        this.idblog = idblog;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
        this.image = image;
        this.tag = tag;
        this.status = status;
        this.ct1 = ct1;
        this.ct2 = ct2;
        this.ct3 = ct3;
        this.image1 = image1;
        this.image2 = image2;
    }

    public int getIdblog() {
        return idblog;
    }

    public void setIdblog(int idblog) {
        this.idblog = idblog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCt1() {
        return ct1;
    }

    public void setCt1(String ct1) {
        this.ct1 = ct1;
    }

    public String getCt2() {
        return ct2;
    }

    public void setCt2(String ct2) {
        this.ct2 = ct2;
    }

    public String getCt3() {
        return ct3;
    }

    public void setCt3(String ct3) {
        this.ct3 = ct3;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    @Override
    public String toString() {
        return "BlogDetail{" +
                "idblog=" + idblog +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                ", tag='" + tag + '\'' +
                ", status=" + status +
                ", ct1='" + ct1 + '\'' +
                ", ct2='" + ct2 + '\'' +
                ", ct3='" + ct3 + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                '}';
    }
}
