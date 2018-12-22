package com.example.javier.teamworkapp.di;

import android.content.Context;

import com.example.javier.teamworkapp.view.projects.ProjectsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)public interface MainComponent {

    void inject(ProjectsActivity activity);

    Context context();

}
