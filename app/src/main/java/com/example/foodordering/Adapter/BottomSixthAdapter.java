package com.example.foodordering.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.foodordering.Fragments.BottomSixthFragment;
import com.example.foodordering.Model.BottomSixthModel;
import com.example.foodordering.R;
import java.util.List;

public class BottomSixthAdapter extends RecyclerView.Adapter<BottomSixthAdapter.Viewholder> {

    private static final String TAG = "MyAdapter";

    private List<BottomSixthModel> Data;

    private Context mContext;

    public BottomSixthAdapter(List<BottomSixthModel> data, Context context) {
        Data = data;
        mContext = context;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
//        Log.d(TAG, "onCreateViewHolder: Starts");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_sixth, viewGroup, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder viewholder,final int i) {
//        Log.d(TAG, "onBindViewHolder: Starts");
        final BottomSixthModel items = Data.get(i);

        viewholder.Option.setText(Data.get(i).getOption());
        viewholder.Price.setText(Data.get(i).getPrice());
        viewholder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                BottomSixthFragment bottomSixthFragment = new BottomSixthFragment();
                Log.d(TAG, "onCheckedChanged: on");
                bottomSixthFragment.calculateTotal(Integer.parseInt(Data.get(i).getPrice()),isChecked);
            }
        });
    }

    public void setdata(List<BottomSixthModel> data){
        Data = data;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return Data.size();
    }


    static class Viewholder extends RecyclerView.ViewHolder {

        TextView Option;
        TextView Price;
        CheckBox check;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            this.Option = (TextView) itemView.findViewById(R.id.option_sixth);
            this.Price = (TextView) itemView.findViewById(R.id.price_sixth);
            this.check = (CheckBox) itemView.findViewById(R.id.check_sixth);

        }
    }
}
