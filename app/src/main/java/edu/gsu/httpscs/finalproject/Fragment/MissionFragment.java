package edu.gsu.httpscs.finalproject.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.GameActivity;
import edu.gsu.httpscs.finalproject.MissionObject;
import edu.gsu.httpscs.finalproject.R;
import edu.gsu.httpscs.finalproject.UpgradeActivity;
import edu.gsu.httpscs.finalproject.adapter.ListViewAdapter;

public class MissionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private GameActivity mContext;
    private ArrayList<MissionObject> contentList = new ArrayList<MissionObject>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    ListViewAdapter listViewAdapter;

    public MissionFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        initMissionInfo();

    }

    private void initMissionInfo() {
        MissionObject m1 = new MissionObject();
        m1.setPrice(1000);
        m1.setMin(1);
        m1.setSecond(30);
        m1.setMoney(1000);
        MissionObject m2 = new MissionObject();
        m2.setPrice(5000);
        m2.setMin(2);
        m2.setSecond(25);
        m2.setMoney(1000);
        MissionObject m3 = new MissionObject();
        m3.setPrice(10000);
        m3.setMin(3);
        m3.setSecond(40);
        m3.setMoney(1000);

        contentList.add(m1);
        contentList.add(m2);
        contentList.add(m3);

    }
    public ArrayList<MissionObject> getContent(){
        return contentList;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mission, container, false);
        listView = (ListView) view.findViewById(R.id.game_activity_list);
        if(listView != null) {
            listViewAdapter = new ListViewAdapter(MissionFragment.this, getContent());
            listView.setAdapter(listViewAdapter);
        }
        for(int i = 0; i<contentList.size();i++) {
            contentList.get(i).setMoney(50000);
        }
        return view;
    }
}
