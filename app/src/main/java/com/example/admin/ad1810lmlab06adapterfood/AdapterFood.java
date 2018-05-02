package com.example.admin.ad1810lmlab06adapterfood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 06/04/2018.
 */

public class AdapterFood extends ArrayAdapter<Food> {

    Context mContext;
    int mResource;
    ArrayList<Food> mList;

    public AdapterFood(Context context, int resource, ArrayList<Food> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mResource = resource;
        this.mList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            // Nếu row là null thì cần load layout từ RES lên
            LayoutInflater inflater = (LayoutInflater)
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(mResource, null);
        }

        ImageView image = (ImageView) row.findViewById(R.id.itemImage);
        TextView txtName = (TextView) row.findViewById(R.id.itemName);
        TextView txtDesc = (TextView) row.findViewById(R.id.itemDesc);

        Food item = mList.get(position);

        image.setImageResource(item.getImage());
        txtName.setText(item.getName());
        txtDesc.setText(item.getDesct());

        return row;
    }
}
