package com.example.foodordering.Fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.foodordering.Activity.HomeActivity;
import com.example.foodordering.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFirstFragment extends Fragment {

    LinearLayout gpsLinearLayout, searchLinearLayout, homeLinearLayout, officeLinearLayout, addLinearLayout;
    ImageView gpsImageView, searchImageView, homeImageView, officeImageView, addImageView, nextImageView;
    public BottomFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_first, container, false);
        gpsLinearLayout = view.findViewById(R.id.gps_layout);
        searchLinearLayout = view.findViewById(R.id.search_layout);
        homeLinearLayout = view.findViewById(R.id.home_layout);
        officeLinearLayout = view.findViewById(R.id.office_layout);
        addLinearLayout = view.findViewById(R.id.add_layout);

        gpsImageView = view.findViewById(R.id.gps_imageview);
        searchImageView = view.findViewById(R.id.search_imageview);
        homeImageView = view.findViewById(R.id.home_imageview);
        officeImageView = view.findViewById(R.id.office_imageview);
        addImageView = view.findViewById(R.id.add_imageview);
        nextImageView = view.findViewById(R.id.next_imageview);

        gpsLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               gpsImageView.setBackgroundColor(Color.parseColor("#2a8cb0"));
                searchImageView.setBackgroundColor(Color.parseColor("#171861"));
                homeImageView.setBackgroundColor(Color.parseColor("#171861"));
                officeImageView.setBackgroundColor(Color.parseColor("#171861"));
                addImageView.setBackgroundColor(Color.parseColor("#171861"));
            }
        });

        searchLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gpsImageView.setBackgroundColor(Color.parseColor("#171861"));
                searchImageView.setBackgroundColor(Color.parseColor("#2a8cb0"));
                homeImageView.setBackgroundColor(Color.parseColor("#171861"));
                officeImageView.setBackgroundColor(Color.parseColor("#171861"));
                addImageView.setBackgroundColor(Color.parseColor("#171861"));
            }
        });

        homeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gpsImageView.setBackgroundColor(Color.parseColor("#171861"));
                searchImageView.setBackgroundColor(Color.parseColor("#171861"));
                homeImageView.setBackgroundColor(Color.parseColor("#2a8cb0"));
                officeImageView.setBackgroundColor(Color.parseColor("#171861"));
                addImageView.setBackgroundColor(Color.parseColor("#171861"));
            }
        });

        officeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gpsImageView.setBackgroundColor(Color.parseColor("#171861"));
                searchImageView.setBackgroundColor(Color.parseColor("#171861"));
                homeImageView.setBackgroundColor(Color.parseColor("#171861"));
                officeImageView.setBackgroundColor(Color.parseColor("#2a8cb0"));
                addImageView.setBackgroundColor(Color.parseColor("#171861"));
            }
        });

        addLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gpsImageView.setBackgroundColor(Color.parseColor("#171861"));
                searchImageView.setBackgroundColor(Color.parseColor("#171861"));
                homeImageView.setBackgroundColor(Color.parseColor("#171861"));
                officeImageView.setBackgroundColor(Color.parseColor("#171861"));
                addImageView.setBackgroundColor(Color.parseColor("#2a8cb0"));
            }
        });

        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.bottom_fragment_container,new BottomSecondFragment(),null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;

    }

}
