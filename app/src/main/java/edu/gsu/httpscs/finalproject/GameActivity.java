package edu.gsu.httpscs.finalproject;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import edu.gsu.httpscs.finalproject.adapter.ListAdapter;
import edu.gsu.httpscs.finalproject.dialog.SettingDialog;

public class GameActivity extends AppCompatActivity {

    ListView listView;
    int[] imgs = {};
    String[] price = {"1000 G","3500 G","7000 G","10000 G","15000 G","20000 G","50000 G","70000 G"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        listView = (ListView) findViewById(R.id.game_activity_list);

        ListAdapter adapter = new ListAdapter(this,imgs,price);
        listView.setAdapter(adapter);

        final ImageView backgroundOne = (ImageView) findViewById(R.id.game_activity_animation1);
        final ImageView backgroundTwo = (ImageView) findViewById(R.id.game_activity_animation2);
        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(7500L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = backgroundOne.getWidth();
                final float translationX = width * progress;
                backgroundOne.setTranslationX(translationX);
                backgroundTwo.setTranslationX(translationX - width);
            }
        });
        animator.start();


    }

    @Override
    public void onBackPressed() {
        SettingDialog dialog = new SettingDialog(GameActivity.this);
        dialog.show();
    }
}
