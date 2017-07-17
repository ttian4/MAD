package edu.gsu.httpscs.finalproject.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.GameActivity;
import edu.gsu.httpscs.finalproject.MainActivity;
import edu.gsu.httpscs.finalproject.R;
import edu.gsu.httpscs.finalproject.StartActivity;
import edu.gsu.httpscs.finalproject.service.MusicService;

public class HeroSelectionDialog extends Dialog {

    Activity activity;
    private String selectedID;
    @BindView(R.id.hero_selection_radio_group)
    RadioGroup radioGroup;

    @OnClick(R.id.hero_selection_ok)
    public void ok(View v){
        Intent intent  = new Intent(activity,GameActivity.class);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        if (radioButtonID == -1){
            //no item is selected
        }
        else if (radioButtonID == R.id.mayunlu_image){
            intent.putExtra("imageID",R.mipmap.lulu);
        }
        else if (radioButtonID == R.id.sunce_image) {
            intent.putExtra("imageID",R.mipmap.cece);
        }
        else if (radioButtonID == R.id.xiahoudun_image){
            intent.putExtra("imageID",R.mipmap.dundun);
        }
        activity.setResult(Activity.RESULT_OK,intent);
        activity.startActivity(intent);
        this.dismiss();

    }
    public HeroSelectionDialog(Activity actvitiy) {

        super(actvitiy);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.activity = actvitiy;
        setContentView(R.layout.activity_hero_selection_dialog);
        ButterKnife.bind(this);
    }
}
