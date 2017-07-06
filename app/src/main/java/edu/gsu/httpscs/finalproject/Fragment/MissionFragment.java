package edu.gsu.httpscs.finalproject.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import butterknife.ButterKnife;
import edu.gsu.httpscs.finalproject.R;
import edu.gsu.httpscs.finalproject.UpgradeActivity;
import edu.gsu.httpscs.finalproject.adapter.ListAdapter;
import edu.gsu.httpscs.finalproject.adapter.listViewAdapter;

public class MissionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public int money = 1000;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    int[] imgs = {};
    String[] price = {"1000","2000","5000","10000","20000"};
    private String[] mins = {"1","2","3","4","5"};
    private String[] second = {"00","10","20","30","40"};

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mission, container, false);
        listView = (ListView) view.findViewById(R.id.game_activity_list);
        if(listView != null) {
            listViewAdapter adapter = new listViewAdapter(imgs, price,this.getContext());
            listView.setAdapter(adapter);

        }
        return view;
    }

}
