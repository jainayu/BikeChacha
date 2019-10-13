package com.example.foodordering.Fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodordering.Activity.HomeActivity;
import com.example.foodordering.Adapter.BottomSixthAdapter;
import com.example.foodordering.Model.BottomSixthModel;
import com.example.foodordering.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomSixthFragment extends Fragment {

    ImageView nextImageView;
    private TextView Total;
    private int sum = 0;
    List<BottomSixthModel> data = new ArrayList<>();

    public BottomSixthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: on");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sixth, container, false);
        Total = (TextView) view.findViewById(R.id.total);
        nextImageView = view.findViewById(R.id.next_imageview);
        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.bottom_fragment_container,new BottomSeventhFragment(),null)
                        .addToBackStack(null)
                        .commit();
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_sixth);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        BottomSixthAdapter bottomSixthAdapter = new BottomSixthAdapter(data, getContext());
        for(int i=1;i<=10;i++){
            BottomSixthModel bottomSixthModel = new BottomSixthModel();
            bottomSixthModel.setPrice(Integer.toString(i+100));
            bottomSixthModel.setOption("Option "+Integer.toString(i+100));
            data.add(bottomSixthModel);
        }
        if(data!=null && bottomSixthAdapter!=null) {
            bottomSixthAdapter.setdata(data);
        }
        //recyclerView.setAdapter(bottomSixthAdapter);

        return view;
    }



    public void calculateTotal(int p, boolean flag){
        Total = (TextView)getActivity().findViewById(R.id.total);
        Log.d("TAG", "calculateTotal: "+p+" "+flag);
        if(flag)
            sum=sum+p;
        else
            sum=sum-p;

        //Total.setText(sum);

    }

}
