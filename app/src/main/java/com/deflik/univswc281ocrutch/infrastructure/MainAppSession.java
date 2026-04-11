package com.deflik.univswc281ocrutch.infrastructure;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.car.app.Screen;
import androidx.car.app.Session;

public class MainAppSession extends Session {
    @NonNull
    @Override
    public Screen onCreateScreen(@NonNull Intent intent) {
        return new MainAppScreen(getCarContext());
    }
}
