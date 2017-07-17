package edu.gsu.httpscs.finalproject;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import edu.gsu.httpscs.finalproject.adapter.ViewFragmentStateAdapter;
import edu.gsu.httpscs.finalproject.dialog.SettingDialog;
import edu.gsu.httpscs.finalproject.service.MusicService;
import edu.gsu.httpscs.finalproject.util.UtilLog;

public class GameActivity extends BaseActivity implements ViewPager.OnTouchListener {
    private ArrayList<Pair<String ,Fragment>> list = new ArrayList<Pair<String,Fragment>>();
    @BindView(R.id.activity_game_tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.activity_game_viewPager)
    ViewPager viewPager;
    @BindView(R.id.game_activity_bg)
    ImageView imageView;
    @BindView(R.id.main_frame_monster)
    ImageView character;
    private int sumX;
    private int sumY;

    ListView listView;
    private GestureDetector gestrueDetector;
    private Intent startIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent = new Intent(StartActivity.ACTION_CLOSE);
//        sendBroadcast(intent);

        startIntent = new Intent(this,MusicService.class);
        startIntent.putExtra("Start",false);
        startService(startIntent);
        registerBrocast();
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
    protected void onDestroy() {
        super.onDestroy();
        Intent stopIntent = new Intent(this,MusicService.class);
        stopIntent.putExtra("Start",false);
        stopService(stopIntent);
//        registerBrocast();
    }

    private void registerBrocast() {
        MusicReceiver receiver = new MusicReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MusicService.PLAYING);
        registerReceiver(receiver, filter);
    }

    @Override
    public void onBackPressed() {
        final SettingDialog dialog = new SettingDialog(this, new SettingDialog.CustomDialogListener() {
            @Override
            public void onOKLicked(String msg) {
                if(msg.equals("yes")){
                    Intent stopIntent = new Intent(getApplicationContext(),MusicService.class);
                    stopIntent.putExtra("Start",false);
                    stopService(stopIntent);
                    System.exit(0);

                }
            }
        });
        dialog.show();

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestrueDetector.onTouchEvent(event);
    }
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
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
        public boolean onSingleTapConfirmed(MotionEvent e) {
            showToast("You have attacked the monster - 1hp");
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(character,"scaleX",0,2,1);
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(character,"scaleY",0,2,1);
            animatorX.setDuration(500);
            animatorY.setDuration(500);
            animatorX.start();
            animatorY.start();
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return super.onDown(e);
        }
    }
    public class MusicReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(MusicService.PLAYING)) {
                if(intent.getBooleanExtra("Start",true)){
                    Intent play = new Intent(context, MusicService.class);
                    context.startService(play);
                }

        }
    }
}}
