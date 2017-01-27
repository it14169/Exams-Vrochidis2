package com.example.user.exams_vrochidis;

/**
 * Created by user on 27/1/2017.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MerchantAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Merchant> merchants;
    private Context context;

    public MerchantAdapter(Context context, ArrayList<Merchant> objects) {
        super(context, 0, objects);
        this.merchants = objects;
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;
        Merchant m = merchants.get(position);

        if(rowView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_merchant, null);
            viewHolder = new ViewHolder(rowView);
            rowView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)rowView.getTag();
        }

        viewHolder.imageView.setImageResource(R.drawable.yummy_logo);
        viewHolder.legalNameView.setText(m.getLegalName());
        //.....
        return  rowView;
    }

    static class ViewHolder (View view) {
        super(view);

        public final ImageView imageView;
        public final TextView legalNameView;
        public final TextView categoryNameView;
        public final TextView addressView;
        public final TextView ratingView;

        public ViewHolder(View view){
            imageView = (ImageView)view.findViewById(R.id.star);
            legalNameView = (TextView)view.findViewById(R.id.tv_legalName);
            categoryNameView = (TextView)view.findViewById(R.id.tv_Categoryname);
            addressView = (TextView)view.findViewById(R.id.tv_adressView);
            ratingView = (TextView)view.findViewById(R.id.tv_ratingView);
        }
    }
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        if (viewType == 0) {
            int layoutIdForListItem = R.layout.merchants_list;
            View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
            return new MerchantAdapter.ViewHolder(view);
        } else if (viewType == 1) {
            int layoutIdForListItem = R.layout.flights_list_item_with_return;
            View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
            return new MerchantAdapter.ViewHolder(view);
        }

        return null;
    }
}

