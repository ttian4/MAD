package edu.gsu.httpscs.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpgradeActivity extends AppCompatActivity {

    @OnClick(R.id.list_item_unlock)
    public void unlock(){
        Button bt = (Button) findViewById(R.id.list_item_unlock);
        bt.setText("upgrade");
        ProgressBar pb = (ProgressBar) findViewById(R.id.list_item_progressBar);
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mission);
        ButterKnife.bind(this);
    }
}
