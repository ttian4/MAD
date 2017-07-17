package edu.gsu.httpscs.finalproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {
    public static final String ACTION_CLOSE = "edu.gsu.httpscs.finalproject.ACTION_CLOSE";
    private StartReciever startReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

//        IntentFilter filter = new IntentFilter(ACTION_CLOSE);
//        startReceiver = new StartReciever();
//        registerReceiver(startReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(startReceiver);
    }
    class StartReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(ACTION_CLOSE)){
                StartActivity.this.finish();
            }
        }
    }
}
