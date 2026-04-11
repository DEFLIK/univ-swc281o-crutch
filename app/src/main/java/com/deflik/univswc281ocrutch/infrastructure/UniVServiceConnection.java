package com.deflik.univswc281ocrutch.infrastructure;

import android.car.Car;
import android.car.hardware.cabin.CarCabinManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class UniVServiceConnection implements ServiceConnection {
    private Car uniV;

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            Log.i("I", "univcrutch connection received");
            var uniVCabinManager = (CarCabinManager) uniV.getCarManager(Car.CABIN_SERVICE);
            Log.i("I", "univcrutch manager created");
            var propsList = uniVCabinManager.getPropertyList();
            Log.i("I", "univcrutch props obtained");
            for (var prop : propsList) {
                Log.i("univcrutch props", prop.toString());
            }
        } catch (Exception e) {
            Log.i("I", "univ connection exception" + e);
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    public void bindBeforeConnection(Car uniV) {
        this.uniV = uniV;
    }
}
