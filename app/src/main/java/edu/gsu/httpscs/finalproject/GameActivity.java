package edu.gsu.httpscs.finalproject;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.Fragment.HeroFragment;
import edu.gsu.httpscs.finalproject.Fragment.MissionFragment;
import edu.gsu.httpscs.finalproject.adapter.ListAdapter;
import edu.gsu.httpscs.finalproject.adapter.ViewFragmentStateAdapter;
import edu.gsu.httpscs.finalproject.dialog.SettingDialog;
import edu.gsu.httpscs.finalproject.util.UtilLog;

public class GameActivity extends BaseActivity implements ViewPager.OnTouchListener {
    private ArrayList<Pair<String ,Fragment>> list = new ArrayList<Pair<String,Fragment>>();
    @BindView(R.id.activity_game_tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.activity_game_viewPager)
    ViewPager viewPager;
    @BindView(R.id.game_activity_bg)
    ImageView imageView;
    private int sumX;
    private int sumY;

    ListView listView;
    private GestureDetector gestrueDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        int source = getIntent().getIntExtra("imageID",0);
        Bundle bundle = new Bundle();
        bundle.putInt("imageID",source);
        HeroFragment frag = new HeroFragment();
        frag.setArguments(bundle);
        list.add(new Pair<String,  Fragment>("Hero", frag));
        list.add(new Pair<String,  Fragment>("Misson",new MissionFragment()));
        list.add(new Pair<String,  Fragment>("Store", new HeroFragment()));
        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        gestrueDetector = new GestureDetector(this, new simpleGestureListener());
        imageView.setOnTouchListener(this);
        imageView.setFocusable(true);
        imageView.setClickable(true);
        imageView.setLongClickable(true);
    }
    @Override
    public void onBackPressed() {
        SettingDialog dialog = new SettingDialog(GameActivity.this);
        dialog.show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestrueDetector.onTouchEvent(event);
    }
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            shortToast("onSingleTapUp");
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            shortToast("onLongPress");
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.d("Gesture","onScroll");
            UtilLog.d("Gesture","DistanceX"+distanceX);
            sumX+=distanceX;
            UtilLog.d("Gesture","DistanceY"+distanceY);
            sumY+=distanceY;
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.d("Gesture","onFling");
            if(sumX<0){
                if(Math.abs(sumX)>200) {
                    shortToast("You scroll from left to right");
                }
            }
            if(sumX>0){
                if(Math.abs(sumX)>200) {
                    shortToast("You scroll from right to left");
                }
            }
            if(sumY<0){
                if(Math.abs(sumY)>200) {
                    shortToast("You scroll from top to bottom");
                }
            }
            if(sumY>0){
                if(Math.abs(sumY)>200) {
                    shortToast("You scroll from bottom to top");
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            shortToast("onShowPress");
            super.onShowPress(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            shortToast("onSingleTapConfirmed");
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            shortToast("onDown");
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            shortToast("onDoubleTap");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            shortToast("onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }
    }
};
