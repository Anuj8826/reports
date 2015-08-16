package com.example.anuj.reports;

/**
 * Created by anuj on 9/8/15.
 */
public class ReceiptList {

    private String Merchandise;
    private String Date;
    private String Price;
    private String Logo;


    public String getMerchandise() {
        return Merchandise;
    }

    public void setMerchandise(String merchandise) {
        this.Merchandise = merchandise;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price = price;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        this.Logo = logo;
    }
}
