package com.example.anuj.reports;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj on 9/8/15.
 */
public class ReceiptListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    ImageLoader imageLoader;
    private List<ReceiptList> receiptLists = null;
    private ArrayList<ReceiptList> arraylist;

    public ReceiptListViewAdapter(Context context,
                                List<ReceiptList> receiptLists) {
        this.mContext = context;
        this.receiptLists = receiptLists;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<ReceiptList>();
        this.arraylist.addAll(receiptLists);
        imageLoader = new ImageLoader(context);
    }

    public class ViewHolder {
        TextView Merchandise;
        TextView Price;
        ImageView Logo;
    }

    @Override
    public int getCount() {
        return receiptLists.size();
    }

    @Override
    public ReceiptList getItem(int position) {
        return receiptLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.receipt_list_row, null);

            // Locate the TextViews in list_row.xml
            holder.Merchandise = (TextView) view.findViewById(R.id.merchandise);
            holder.Price = (TextView) view.findViewById(R.id.price);
            holder.Logo = (ImageView) view.findViewById(R.id.thumbnail);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.Merchandise.setText(receiptLists.get(position).getMerchandise());
        holder.Price.setText(receiptLists.get(position).getPrice());


        // Set the results into ImageView
        imageLoader.DisplayImage(receiptLists.get(position).getLogo(),
                holder.Logo);

        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleReceiptView.class);
                // Pass all data rank
                intent.putExtra("merchandise",
                        (receiptLists.get(position).getMerchandise()));
                // Pass all data country
                intent.putExtra("price",
                        (receiptLists.get(position).getPrice()));
                // Pass all data pic
                intent.putExtra("logo",
                        (receiptLists.get(position).getLogo()));
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }
}
