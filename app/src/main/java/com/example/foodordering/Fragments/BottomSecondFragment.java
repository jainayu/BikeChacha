package com.example.foodordering.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.foodordering.Activity.HomeActivity;
import com.example.foodordering.Adapter.VehicleDetailsAdapter;
import com.example.foodordering.Model.VehicleDetailsModel;
import com.example.foodordering.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomSecondFragment extends Fragment {

    RecyclerView vehicleDetailsAdapter;
    ImageView nextImageView;
    private List<VehicleDetailsModel> vehicleDetailsModels = new ArrayList<>();
    public BottomSecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_second, container, false);

        nextImageView = view.findViewById(R.id.next_imageview);
        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.bottom_fragment_container,new BottomFifthFragment(),null)
                        .addToBackStack(null)
                        .commit();
            }
        });
        RecyclerView vehicleRecyclerView = view.findViewById(R.id.vehical_recycler_view);
        vehicleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        vehicleDetailsModels.clear();
        VehicleDetailsModel vehicleDetailsModel = new VehicleDetailsModel();
        vehicleDetailsModel.setViewType(VehicleDetailsModel.VEHICLE_DETAILS_ITEM);
        vehicleDetailsModels.add(vehicleDetailsModel);

        vehicleDetailsModel = new VehicleDetailsModel();
        vehicleDetailsModel.setViewType(VehicleDetailsModel.VEHICLE_DETAILS_ITEM);
        vehicleDetailsModels.add(vehicleDetailsModel);

        vehicleDetailsModel = new VehicleDetailsModel();
        vehicleDetailsModel.setViewType(VehicleDetailsModel.ADD_VEHICLE_DETAILS_ITEM);
        vehicleDetailsModels.add(vehicleDetailsModel);

        VehicleDetailsAdapter vehicleDetailsAdapter = new VehicleDetailsAdapter(vehicleDetailsModels, getContext());
        vehicleRecyclerView.setAdapter(vehicleDetailsAdapter);

        return view;
    }

}
