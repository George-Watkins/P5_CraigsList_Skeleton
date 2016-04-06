package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


public class customAdapter extends BaseAdapter{
    Context context;
    List<BikeData> rowItems;
    LayoutInflater myInflater;


    public class ViewHolder {
        ImageView thumbNail;
        TextView tvDescription;
        TextView tvTitle;
        TextView tvPrice;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        myInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = myInflater.inflate(R.layout.listview_row_layout, null);
            holder = new ViewHolder();
            holder.tvDescription = (TextView)convertView.findViewById(R.id.Description);
            holder.tvTitle       = (TextView)convertView.findViewById(R.id.Title);
            holder.tvPrice       = (TextView)convertView.findViewById(R.id.Price);
            holder.thumbNail     = (ImageView)convertView.findViewById(R.id.thumbnail);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        BikeData bikeData = (BikeData) getItem(position);

        holder.tvDescription.setText("Fix this, need to get from builder class");
        holder.tvTitle.setText("Fix this, need to get from builer class");
        holder.tvPrice.setText("Fix this, need to get from builer class");
        holder.thumbNail.setImageResource(R.drawable.bike3);

        return convertView;
    }
}
