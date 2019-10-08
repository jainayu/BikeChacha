package com.example.foodordering.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFrag extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getTargetFragment(), year, month,day);
        Calendar cal=Calendar.getInstance();
        dialog.getDatePicker().setMinDate(cal.getTime().getTime()-1000);
        cal.add(Calendar.DATE, 30);
        Date dte =cal.getTime();
        dialog.getDatePicker().setMaxDate(dte.getTime());
        dialog.getDatePicker().setCalendarViewShown(true);
        dialog.getDatePicker().setSpinnersShown(false);
        dialog.setCancelable(true);

        return dialog;
    }
}
