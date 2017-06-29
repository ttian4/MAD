package edu.gsu.httpscs.finalproject;

import android.animation.ValueAnimator;
import android.content.Context;
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
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.LinearInterpolator;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;

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

public class GameActivity extends AppCompatActivity {
    private ArrayList<Pair<String ,Fragment>> list = new ArrayList<Pair<String,Fragment>>();
    @BindView(R.id.activity_game_tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.activity_game_viewPager)
    ViewPager viewPager;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        list.add(new Pair<String,  Fragment>("Hero", new HeroFragment()));
        list.add(new Pair<String,  Fragment>("Misson",new MissionFragment()));
        list.add(new Pair<String,  Fragment>("Store", new HeroFragment()));
        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    @Override
    public void onBackPressed() {
        SettingDialog dialog = new SettingDialog(GameActivity.this);
        dialog.show();
    }
}
