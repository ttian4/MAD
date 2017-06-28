package edu.gsu.httpscs.finalproject.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.R;

public class SettingDialog extends Dialog{

    Activity activity;

    @OnClick(R.id.dialog_yes)
    public void yes(View view){
        activity.finish();
    }
    @OnClick(R.id.dialog_no)
    public void no(View view){
        dismiss();
    }

    public SettingDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_dialog);
        ButterKnife.bind(this);


    }
}
