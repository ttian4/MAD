package edu.gsu.httpscs.finalproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.IntegerRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import edu.gsu.httpscs.finalproject.R;
import edu.gsu.httpscs.finalproject.UpgradeActivity;

/**
 * Created by Tong on 2017/7/5.
 */

public class listViewAdapter extends BaseAdapter {
    int[] imgs = {};
    String[] prices = {};
    String[] second ={};
    String[] mins = {};
    int location;
    int money =10000;
    Context context;
    LayoutInflater inflater;

    public class ViewHolder{
        TextView pirceTextView;
//        TextView minsTV;
//        TextView secondTV;
        Button bt;

    }
    public listViewAdapter(int[] imgs,String[] prices, Context context) {
        this.imgs = imgs;
        this.mins = mins;
        this.second = second;
        this.prices = prices;
        this.context = context;
    }

    @Override
    public int getCount() {
        return prices.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }


    @Override
    public long getItemId(int position) {
        location = position;
        return position;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.pirceTextView = (TextView) convertView.findViewById(R.id.list_item_price);
//        holder.minsTV = (TextView) convertView.findViewById(R.id.list_item_timerMins);
//        holder.secondTV = (TextView) convertView.findViewById(R.id.list_item_timerSecond);
        holder.bt = (Button) convertView.findViewById(R.id.list_item_unlock);

        holder.pirceTextView.setText(prices[position]);
//        holder.minsTV.setText(mins[position]);
//        holder.secondTV.setText(second[position]);
        final View finalConvertView = convertView;
        if(money < Integer.parseInt(prices[position])){
            System.out.println("getin");
            holder.bt.setFocusable(false);
            holder.bt.setClickable(false);
            holder.bt.setActivated(false);
            holder.bt.setBackgroundColor(Color.GRAY);
            holder.bt.setText("LOCKED");
        }
        else{
            holder.bt.setOnClickListener(new View.OnClickListener() {
                Button bt = (Button) finalConvertView.findViewById(R.id.list_item_unlock);
                TextView price = (TextView)finalConvertView.findViewById(R.id.list_item_price);
                @Override
                public void onClick(View v) {
                    if(bt.getText().equals("unlock")){
                        bt.setText("upgrade");
                        ProgressBar pb = (ProgressBar) finalConvertView.findViewById(R.id.list_item_progressBar);
                        pb.setVisibility(View.VISIBLE);
                    }
                    else if(bt.getText().equals("upgrade")){
                        price.setText(""+(int)(Integer.parseInt(prices[location])+Integer.parseInt(prices[location])*0.05));
                    }
                }
            });
        }
        return finalConvertView;
    }

}
