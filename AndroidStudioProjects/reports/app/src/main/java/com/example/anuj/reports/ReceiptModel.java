package com.example.anuj.reports;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by anuj on 9/8/15.
 */
@ParseClassName("ReceiptModel")
public class ReceiptModel extends ParseObject {

    public ReceiptModel () {

    }

    public String  getMerchandise() {return getString("merchandise");
    }

    public void setMerchandise(String merchandise) {
        put("merchandise", merchandise);
    }

    public String getPrice() {
        return getString("price");
    }

    public void setPrice(String price) {
        put("price", price);
    }

    public String getDate() {
        return getString("date");
    }

    public void setDate(String date) {
        put("date", date);
    }


    public ParseFile getImageFile() {
        return getParseFile("photo");
    }

    public void setImageFile(ParseFile file) {
        put("photo", file);
    }

}
