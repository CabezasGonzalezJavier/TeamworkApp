package com.example.javier.teamworkapp;

import android.app.Application;

import com.example.javier.teamworkapp.di.DaggerMainComponent;
import com.example.javier.teamworkapp.di.MainComponent;
import com.example.javier.teamworkapp.di.MainModule;

public class ProjectApplication extends Application {

    private MainComponent mainComponent;

    @Override public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
