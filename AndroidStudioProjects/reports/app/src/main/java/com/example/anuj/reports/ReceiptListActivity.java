package com.example.anuj.reports;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj on 9/8/15.
 */
public class ReceiptListActivity extends Activity {

    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ReceiptListViewAdapter adapter;
    private List<ReceiptList> receiptList = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from product_list.xml
        Toast.makeText(ReceiptListActivity.this, "Congrats !!", Toast.LENGTH_LONG).show();
        setContentView(R.layout.receipt_list);
        Toast.makeText(ReceiptListActivity.this, "Congrats 2!!", Toast.LENGTH_LONG).show();
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();


    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(ReceiptListActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Getting Data from the Server");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            receiptList = new ArrayList<ReceiptList>();
            try {
                // Locate the class table named "Country" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                        "ReceiptModel");

                ob = query.find();
                for (ParseObject product : ob) {

                    // Locate images in photo column
                    ParseFile image = (ParseFile) product.get("photo");

                    ReceiptList map = new ReceiptList();
                    map.setMerchandise((String) product.get("merchandise"));
                    map.setPrice((String) product.get("price"));
                    map.setDate((String) product.get("date"));
                    map.setLogo(image.getUrl());
                    receiptList.add(map);
                }

            } catch (com.parse.ParseException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.list);
            // Pass the results into ListViewAdapter.java
            adapter = new ReceiptListViewAdapter(ReceiptListActivity.this,
                    receiptList);
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}
