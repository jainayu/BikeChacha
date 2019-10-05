package com.example.foodordering.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.Activity.HomeActivity;
import com.example.foodordering.Fragments.BottomSeventhFragment;
import com.example.foodordering.Fragments.BottomThirdFragment;
import com.example.foodordering.Model.VehicleDetailsModel;
import com.example.foodordering.R;

import java.util.List;

public class VehicleDetailsAdapter extends RecyclerView.Adapter {

    static final int VEHICLE_DETAILS_ITEM = 1;
    static final int ADD_VEHICLE_DETAILS_ITEM =2;
    List<VehicleDetailsModel> vehicleDetailsModelList;
    Context context;

    public VehicleDetailsAdapter(List<VehicleDetailsModel> vehicleDetailsModels, Context context){
        this.vehicleDetailsModelList = vehicleDetailsModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case VEHICLE_DETAILS_ITEM:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.vehicle_item_layout, parent,false);
                return new VehicleDetailsViewHolder(view);

            case ADD_VEHICLE_DETAILS_ITEM:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.add_vehicle_item_layout,parent, false);
                return  new AddVehicleDetailsViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.add_vehicle_item_layout,parent, false);
                return  new AddVehicleDetailsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       switch (vehicleDetailsModelList.get(position).getViewType()){
           case VehicleDetailsModel.VEHICLE_DETAILS_ITEM:
               //VehicleDetailsViewHolder vehicleDetailsViewHolder = (VehicleDetailsViewHolder) holder;
               break;
           case VehicleDetailsModel.ADD_VEHICLE_DETAILS_ITEM:
               //AddVehicleDetailsViewHolder addVehicleDetailsViewHolder = (AddVehicleDetailsViewHolder) holder;
               break;
       }
    }

    @Override
    public int getItemCount() {
        return vehicleDetailsModelList.size();
    }

    public class VehicleDetailsViewHolder extends RecyclerView.ViewHolder{

        public VehicleDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class AddVehicleDetailsViewHolder extends RecyclerView.ViewHolder{

        public AddVehicleDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HomeActivity.fragmentManager
                            .beginTransaction()
                            .replace(R.id.bottom_fragment_container,new BottomThirdFragment(),null)
                            .addToBackStack(null)
                            .commit();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(vehicleDetailsModelList.get(position).getViewType().equals(VehicleDetailsModel.VEHICLE_DETAILS_ITEM))
        {
            return VEHICLE_DETAILS_ITEM;
        }
        if(vehicleDetailsModelList.get(position).getViewType().equals(VehicleDetailsModel.ADD_VEHICLE_DETAILS_ITEM))
        {
            return ADD_VEHICLE_DETAILS_ITEM;
        }
        else
        {
            return ADD_VEHICLE_DETAILS_ITEM;
        }
    }
}
