package com.example.foodordering.Fragments;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.foodordering.Activity.HomeActivity;
import com.example.foodordering.R;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFifthFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    private TextView dateset;
    private TextView Timeset;
    ImageView nextImageView;
    BottomFifthFragment mlistener;
    public BottomFifthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_fifth, container, false);

        nextImageView = view.findViewById(R.id.next_imageview);
        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.bottom_fragment_container,new BottomSixthFragment(),null)
                        .addToBackStack(null)
                        .commit();
            }
        });
        TextView dateset = (TextView) view.findViewById(R.id.datepicker);
        TextView Timeset = (TextView) view.findViewById(R.id.timepicker);
        dateset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.setTargetFragment(BottomFifthFragment.this,0);
                datePicker.show(getFragmentManager(), "date picker");
            }
        });
        Timeset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new TimePickerFragment();
                timepicker.setTargetFragment(BottomFifthFragment.this, 0);
                timepicker.show(getFragmentManager(), "time picker");
            }
        });
        return view;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance().format(c.getTime());
        dateset = (TextView)getActivity().findViewById(R.id.datepicker) ;
        dateset.setText(currentDate);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        String currentTime = DateFormat.getTimeInstance().format(c.getTime());
        Timeset = (TextView)getActivity().findViewById(R.id.timepicker);
        Timeset.setText(currentTime);
    }
}
