package com.example.foodordering.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.foodordering.Activity.HomeActivity;
import com.example.foodordering.Model.BottomSixthModel;
import com.example.foodordering.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomSeventhFragment extends Fragment {

    static String Location;
    static String VehicalName;
    static List<BottomSixthModel> Data;
    static String Total;

    ImageView nextImageView;
    public BottomSeventhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_seventh, container, false);

        nextImageView = view.findViewById(R.id.next_imageview);
        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.bottom_fragment_container,new BottomEigthFragment(),null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    public void setLocation(String location){
        Location = location;
    }

    public void setVehicalname(String vehicalName){
        VehicalName = vehicalName;
    }

    public void setOptions(List<BottomSixthModel> data){
        Data = data;
    }

    public void setTotal(String total){
        Total = total;
    }

}
