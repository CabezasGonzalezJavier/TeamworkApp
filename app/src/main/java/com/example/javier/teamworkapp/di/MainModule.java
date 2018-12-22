package com.example.javier.teamworkapp.di;

import android.content.Context;

import com.example.javier.teamworkapp.ProjectApplication;
import com.example.javier.teamworkapp.data.repository.Repository;

import javax.inject.Named;
import javax.inject.Singleton;

import com.example.javier.teamworkapp.data.repository.RepositoryImpl;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module public class MainModule {

    private final ProjectApplication projectApplication;

    public MainModule(ProjectApplication euroApplication) {
        this.projectApplication = euroApplication;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return projectApplication;
    }

    @Provides @Singleton
    Repository provideRepository(RepositoryImpl repository) {
        return repository;
    }

    @Provides @Named("executor_thread") Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides @Named("ui_thread") Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}
