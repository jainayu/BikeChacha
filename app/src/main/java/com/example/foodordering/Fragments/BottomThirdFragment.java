package com.example.foodordering.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.foodordering.Activity.HomeActivity;
import com.example.foodordering.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomThirdFragment extends Fragment {
    ImageView nextImageView;

    public BottomThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_third, container, false);
        nextImageView = view.findViewById(R.id.next_imageview);
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
