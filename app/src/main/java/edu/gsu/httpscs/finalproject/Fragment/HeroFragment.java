package edu.gsu.httpscs.finalproject.Fragment;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.ButterKnife;
import edu.gsu.httpscs.finalproject.GameActivity;
import edu.gsu.httpscs.finalproject.GameActivity_ViewBinding;
import edu.gsu.httpscs.finalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeroFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String s;


    public HeroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeroFragment newInstance(String param1, String param2) {

        HeroFragment fragment = new HeroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        s = data.getStringExtra("imageID");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hero, container, false);
        Bundle bundle = getArguments();
        if(bundle!=null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.hero_image);
            imageView.setImageResource(getArguments().getInt("imageID"));
            ImageView imageView1 = (ImageView) getActivity().findViewById(R.id.imageView_main_frame);
            imageView1.setImageResource(getArguments().getInt("imageID"));
        }
        return view;
    }

}
