package edu.gsu.httpscs.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Tong on 2017/6/14.
 */

public class BaseActivity extends AppCompatActivity {
    public void showToast(String s) {

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void shortToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void longToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void changeActivity(final Button bt, final Class<? extends Activity> newAct) {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, newAct));
            }
        });
    }
    //public void goToActivity(Class c){
    //    Intent intent = new Intent(this.c);
    //    startActivity(intent);
    //}
}
