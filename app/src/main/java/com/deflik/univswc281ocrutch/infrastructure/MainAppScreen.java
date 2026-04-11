package com.deflik.univswc281ocrutch.infrastructure;

import android.car.Car;
import android.car.hardware.CarPropertyConfig;
import android.car.hardware.cabin.CarCabinManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.Action;
import androidx.car.app.model.MessageTemplate;
import androidx.car.app.model.Template;

import java.util.List;

public class MainAppScreen extends Screen {
    private CarCabinManager uniVCabinManager;
    private List<CarPropertyConfig> propsList;

    public MainAppScreen(CarContext carContext) {
        super(carContext);

        var uniV = Car.createCar(carContext, new UniVServiceConnection());
        try {
            uniV.connect();
            uniVCabinManager = (CarCabinManager) uniV.getCarManager(Car.CABIN_SERVICE);
            propsList = uniVCabinManager.getPropertyList(); // todo
            for (var prop : propsList) {
                Log.i("UniVCrutch", prop.toString());
            }
        } catch (Exception e) {
            Log.e("UniVCrutch", "exception" + e);
        }
    }

    @NonNull
    @Override
    public Template onGetTemplate() {
        Action myButton = new Action.Builder()
                .setTitle("Нажми меня")
                .setOnClickListener(() -> {
                    // Логика при нажатии
                    System.out.println("Кнопка нажата!");
                })
                .build();

        // 2. Возвращаем шаблон с этой кнопкой
        return new MessageTemplate.Builder("Привет из Java!")
                .setTitle("Мое Авто Приложение")
                .setHeaderAction(Action.APP_ICON)
                .addAction(myButton)
                .build();
    }
}

