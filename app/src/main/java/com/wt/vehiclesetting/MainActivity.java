package com.wt.vehiclesetting;

import android.car.Car;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.deflik.univswc281ocrutch.infrastructure.UniVServiceConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("I", "univcrutch started");
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        setContentView(R.layout.activity_main);
//
//        var textView = (TextView) findViewById(R.id.textView);
//        runOnUiThread(() -> textView.append("started"));

        var uniVServiceConnection = new UniVServiceConnection();
        var uniV = Car.createCar(getApplicationContext(), uniVServiceConnection);
        uniVServiceConnection.bindBeforeConnection(uniV);
        try {

            Log.i("I", "univcrutch car createde");
            uniV.connect();
            Log.i("I", "univcrutch car connection started");
        } catch (Exception e) {
            Log.e("I", "univcrutch exception" + e);
        }
//        uniVCabinManager.getBooleanProperty(UniVMCUOptionIds.EXHAUST_NOISE, );
    }
}