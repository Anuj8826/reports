package com.example.anuj.reports;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by anuj on 10/8/15.
 */
public class SingleReceiptView extends Activity {

    TextView txtmerchandise;
    TextView txtprice;
    String merchandise;
    String price;
    String logo;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_receipt_view);
        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();
        // Get the results of rank
        merchandise = i.getStringExtra("merchandise");
        // Get the results of country
        price = i.getStringExtra("price");
        // Get the result of flag
        logo = i.getStringExtra("logo");

        // Locate the TextViews in singleitemview.xml
        txtmerchandise = (TextView) findViewById(R.id.merchandise);
        txtprice = (TextView) findViewById(R.id.price);
        ImageView imgflag = (ImageView) findViewById(R.id.thumbnail);

        // Load the results into the TextViews
        txtmerchandise.setText(merchandise);
        txtprice.setText(price);
        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(logo, imgflag);


    }
}
