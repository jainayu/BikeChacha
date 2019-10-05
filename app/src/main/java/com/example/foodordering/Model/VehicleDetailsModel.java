package com.example.foodordering.Model;

public class VehicleDetailsModel {
    public static final String VEHICLE_DETAILS_ITEM = "VEHICLE_DETAILS_ITEM";
    public static final String ADD_VEHICLE_DETAILS_ITEM = "ADD_VEHICLE_DETAILS_ITEM";
    String text;
    String viewType;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }



}

