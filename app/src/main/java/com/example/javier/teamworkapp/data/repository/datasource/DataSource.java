package com.example.javier.teamworkapp.data.repository.datasource;

import com.example.javier.teamworkapp.data.entity.Project;
import io.reactivex.Observable;

import java.util.List;


public interface DataSource {
    Observable<List<Project>> getProjectEntity();
}
