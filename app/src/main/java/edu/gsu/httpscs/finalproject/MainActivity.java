package edu.gsu.httpscs.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.dialog.HeroSelectionDialog;
import edu.gsu.httpscs.finalproject.dialog.SettingDialog;

public class MainActivity extends AppCompatActivity {
    private View view;

    @OnClick(R.id.main_activity_start)
    public void start(View v){
        HeroSelectionDialog heroSelectionDialog = new HeroSelectionDialog(MainActivity.this);
        heroSelectionDialog.show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start); //change back to activity_main later
        ButterKnife.bind(this);
    }
}
