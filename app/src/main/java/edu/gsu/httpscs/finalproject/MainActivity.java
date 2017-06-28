package edu.gsu.httpscs.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.main_activity_start)
    public void start(View v){
        startActivity(new Intent(MainActivity.this,GameActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start); //change back to activity_main later
        ButterKnife.bind(this);
    }
}
