package com.deflik.univswc281ocrutch.services;

import android.car.CarNotConnectedException;
import android.car.hardware.cabin.CarCabinManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.deflik.univswc281ocrutch.models.UniVMCUOptionIds;
import com.wt.vehiclesetting.R;

public class UniVSettingsController {

    private final AppCompatActivity activity;

    public UniVSettingsController(AppCompatActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void RegisterCabinManager(CarCabinManager uniVCabinManager) {
        TextView textView = activity.findViewById(R.id.textView);
        activity.runOnUiThread(() -> textView.append("started "));

        Button buttonOpen = activity.findViewById(R.id.exhaustOpenButton);
        buttonOpen.setOnClickListener(view -> {
            activity.runOnUiThread(() -> textView.append("open "));
            try {
                uniVCabinManager.setIntProperty(UniVMCUOptionIds.EXHAUST_NOISE, 1, 0);
            } catch (CarNotConnectedException e) {
                throw new RuntimeException(e);
            }
        });

        Button buttonClose = activity.findViewById(R.id.exhaustCloseButton);
        buttonClose.setOnClickListener(view -> {
            activity.runOnUiThread(() -> textView.append("close "));
            try {
                uniVCabinManager.setIntProperty(UniVMCUOptionIds.EXHAUST_NOISE, 0, 0);
            } catch (CarNotConnectedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void UnregisterCabinManager() {
        // todo
    }
}
