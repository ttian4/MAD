package edu.gsu.httpscs.finalproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import edu.gsu.httpscs.finalproject.R;
/**
 * Created by Tong on 2017/6/27.
 */

public class ListAdapter extends BaseAdapter {

    int[] imgs={};
    String[] price= {};
    Context context;
    LayoutInflater inflater;
    int money = 1000;

    public ListAdapter(Context context, int[] imgs, String[] price) {
        this.context = context;
        this.imgs = imgs;
        this.price = price;
    }

    public class ViewHolder{
        TextView priceTv;
        ImageButton imgBt;
    }
    @Override
    public int getCount() {
        return price.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.list_item,null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.priceTv = (TextView) convertView.findViewById(R.id.list_item_price);
        holder.imgBt = (ImageButton) convertView.findViewById(R.id.list_item_img);

        holder.priceTv.setText(price[position]);
//        holder.imgBt.setImageResource(imgs[position]);       haven't find pictures later edit
        Button bt = (Button) convertView.findViewById(R.id.list_item_unlock);
        final View finalConvertView = convertView;
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button bt = (Button) finalConvertView.findViewById(R.id.list_item_unlock);
                bt.setText("upgrade");
                ProgressBar pb = (ProgressBar) finalConvertView.findViewById(R.id.list_item_progressBar);
                pb.setVisibility(View.VISIBLE);
            }
        });
        return finalConvertView;
    }

}
