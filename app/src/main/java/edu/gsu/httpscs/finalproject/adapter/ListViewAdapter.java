package edu.gsu.httpscs.finalproject.adapter;

import android.os.Handler;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;

import edu.gsu.httpscs.finalproject.MissionObject;
import edu.gsu.httpscs.finalproject.R;
import edu.gsu.httpscs.finalproject.util.UtilTime;


/**
 * Created by Tong on 2017/7/9.
 */

public class ListViewAdapter extends BaseAdapter {
    private static ArrayList<MissionObject> contentList;
    private final Context context;
    private final LayoutInflater inflater;
    private int time1 = 0;
    private int time2 = 0;
    private int time3 = 0;
    ViewHolder viewHolder;
    private Handler handler1 = new Handler();
    private Handler handler2 = new Handler();
    private Handler handler3 = new Handler();
    private class ViewHolder {
        TextView price;
        TextView second;
        TextView mins;
        Button unlock;
        ProgressBar progressBar;
    }
    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            time1 = time1 - 1000;
            if(time1>= 0){

                viewHolder.mins.setText(UtilTime.secToTime(time1));
                handler1.postDelayed(this, 1000);
            }
            else if(time1 < 0 ){
                int newMoney = contentList.get(0).getMoney()+contentList.get(0).getPrice();
                for(int i =0 ;i<contentList.size();i++){
                    contentList.get(0).setMoney(newMoney);
                }
            }
        }
    };
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            time2 = time2 - 1000;
            if(time2>= 0){

                viewHolder.mins.setText(UtilTime.secToTime(time2));
                handler2.postDelayed(this, 1000);
            }
        }
    };
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            time3 = time3 - 1000;
            if(time1>= 0) {

                viewHolder.mins.setText(UtilTime.secToTime(time3));
                handler3.postDelayed(this, 1000);
            }
        }
    };
    public ListViewAdapter(Fragment fragment, ArrayList<MissionObject> contentList) {
        this.contentList = contentList;
        this.context = fragment.getContext();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contentList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MissionObject item = contentList.get(position);
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder.price = (TextView) convertView.findViewById(R.id.list_item_price);
            viewHolder.unlock = (Button) convertView.findViewById(R.id.list_item_unlock);
            viewHolder.mins = (TextView) convertView.findViewById(R.id.list_item_min);
//            viewHolder.second = (TextView) convertView.findViewById(R.id.list_item_second);
            viewHolder.progressBar = (ProgressBar) convertView.findViewById(R.id.list_item_progressBar);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.price.setText("" + item.getPrice());
//        viewHolder.mins.setText(""+item.getMin());
//        viewHolder.second.setText(""+item.getSecond());
        if (item.getMoney() < item.getPrice()) {
            viewHolder.unlock.setClickable(false);
            viewHolder.unlock.setBackgroundColor(Color.GRAY);
        }
        viewHolder.unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder = (ViewHolder) result.getTag();
                switch (position) {
                    case 0:
                        System.out.println("case0"+position);
                        if (contentList.get(0).getMoney() >= contentList.get(0).getPrice()) {
                            if (viewHolder.unlock.getText().equals("unlock")) {
                                viewHolder.unlock.setClickable(true);
                                viewHolder.unlock.setText("upgrade");
                                time1 = contentList.get(0).getMin()*60000+contentList.get(0).getSecond()*1000;
                                handler1.postDelayed(runnable1,1000);
                            } else if (viewHolder.unlock.getText().equals("upgrade")) {
                                int newPrice = (int) (contentList.get(0).getPrice() * 0.05 + contentList.get(0).getPrice());
                                contentList.get(0).setPrice(newPrice);
                                viewHolder.price.setText("" + newPrice);
                            }
                        }
                        break;
                    case 1:
                        System.out.println("case1"+position);
                        if (contentList.get(1).getMoney() >= contentList.get(1).getPrice()) {
                            if (viewHolder.unlock.getText().equals("unlock")) {
                                viewHolder.unlock.setClickable(true);
                                viewHolder.unlock.setText("upgrade");
                                time2 = contentList.get(1).getMin()*60000+contentList.get(1).getSecond()*1000;
                                handler2.postDelayed(runnable2,1000);
                            } else if (viewHolder.unlock.getText().equals("upgrade")) {
                                int newPrice = (int) (contentList.get(1).getPrice() * 0.05 + contentList.get(1).getPrice());
                                contentList.get(1).setPrice(newPrice);
                                viewHolder.price.setText("" + newPrice);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("case2"+position);
                        if (contentList.get(2).getMoney() >= contentList.get(2).getPrice()) {
                            if (viewHolder.unlock.getText().equals("unlock")) {
                                viewHolder.unlock.setClickable(true);
                                viewHolder.unlock.setText("upgrade");
                                time3 = contentList.get(2).getMin()*60000+contentList.get(2).getSecond()*1000;
                                handler3.postDelayed(runnable3,1000);
                            } else if (viewHolder.unlock.getText().equals("upgrade")) {
                                int newPrice = (int) (contentList.get(2).getPrice() * 0.05 + contentList.get(2).getPrice());
                                contentList.get(2).setPrice(newPrice);
                                viewHolder.price.setText("" + newPrice);
                            }
                        }
                        break;
                    default:
                }
            }
        });
        viewHolder.unlock.setTag(position);
        // Return the completed view to render on screen
        return convertView;
//            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
//            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
//            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

    }
//        final ViewHolder holder;
//        if(convertView != null){
//            holder = (ViewHolder) convertView.getTag();
//        }
//        else{
//            convertView = inflater.inflate(R.layout.list_item,parent,false);
//            holder = new ViewHolder(convertView);
//            convertView.setTag(holder);
//        }
//        MissionObject ob = (MissionObject) contentList.get(position);
//        System.out.println(holder.unlock.getText());
//        final int newPrice = (int) (ob.getPrice()*0.05+ob.getPrice());
//        holder.price.setText(String.valueOf(ob.getPrice()));
//        if(ob.getMoney()<ob.getPrice()){
//            holder.unlock.setClickable(false);
//            holder.unlock.setBackgroundColor(Color.GRAY);
//        }
//        else if(holder.unlock.getText().equals("upgrade")){
//            holder.unlock.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    holder.price.setText("23423423423");
//                }
//            });
//        }
//        else{
//            holder.unlock.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(holder.unlock.getText().equals("unlock")){
//                        holder.unlock.setText("Upgrade");
//                    }
//                }
//            });
//        }
//        return convertView;
//    }
//    static class ViewHolder {
//        public ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
//        @BindView(R.id.list_item_price)
//        TextView price;
//        @BindView(R.id.list_item_unlock)
//        Button unlock;
//    }

}
