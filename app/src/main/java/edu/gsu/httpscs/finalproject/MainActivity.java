package edu.gsu.httpscs.finalproject;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.dialog.HeroSelectionDialog;
import edu.gsu.httpscs.finalproject.dialog.SettingDialog;
import edu.gsu.httpscs.finalproject.service.MusicService;

public class MainActivity extends AppCompatActivity {
    private View view;
    @BindView(R.id.main_activity_title)
    TextView textView;
    @BindView(R.id.activity_et_email)
    EditText emailET;
    @BindView(R.id.activity_et_password)
    EditText passwordET;
    private BroadcastReceiver reciver;

    @OnClick(R.id.activity_sharedpreference_bt_login)
    public void login(View v){
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
        builder1.setMessage("You have login sucessfully. Welcome back.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        final HeroSelectionDialog heroSelectionDialog = new HeroSelectionDialog(MainActivity.this);
                        heroSelectionDialog.show();
                    }
                });

        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    private final String EMAIL ="email";
    private final String PASSWORD ="password";
    private final String USER = "user";
    @OnClick(R.id.activity_sharedpreference_bt_clear)
    public void clear(View v){
        SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(EMAIL);
        editor.remove(PASSWORD);
        editor.commit();
        passwordET.setText("");
        emailET.setText("");
    }
    private void retriveLoginInfo() {
        SharedPreferences sp = getSharedPreferences(USER, MODE_PRIVATE);
        String email = sp.getString(EMAIL,"null");
        String password = sp.getString(PASSWORD,"null");
        if(!email.equals("null")){
            emailET.setText(email);
            passwordET.setText(password);
        }
    }
    private boolean check(String email, String password) {
        boolean passwordCorrect = true;
        if(passwordCorrect){
            SharedPreferences sp = getSharedPreferences(USER, MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(EMAIL,email);
            editor.putString(PASSWORD,password);
            editor.commit();
            return true;
        }else{
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start); //change back to activity_main later
        ButterKnife.bind(this);
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView,"rotationY",0,360,0);
        animator.setDuration(5000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
        retriveLoginInfo();
//        Intent play = new Intent(this, MusicService.class);
//        this.startService(play);
    }

}
