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
    String url = "http://www.tetonsoftware.com/bikes/bikes.json";
    private Activity_ListView mainAc;

    public customAdapter(Context context, int resource, List<BikeData> rowItems){
        this.rowItems = rowItems;
    }

    public customAdapter(Activity_ListView activity){
        this.mainAc = activity;
        myInflater = (LayoutInflater)mainAc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder {
        ImageView thumbNail;
        TextView  tvDescription;
        TextView  tvTitle;
        TextView  tvPrice;
        public int position;
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
        holder.position = position;

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

        holder.tvDescription.setText(bikeData.DESCRIPTION);
        holder.tvTitle.setText(bikeData.MODEL);
        holder.tvPrice.setText("Fix this. bikeData.PRICE is a double not a string");
//        holder.thumbNail.setImageResource(R.drawable.bike3);  //bike3 is a preset image.  Need to fix this still.

        new DownloadImageTask(bikeData.PICTURE,holder.thumbNail).execute(url);

        return convertView;
    }
}
