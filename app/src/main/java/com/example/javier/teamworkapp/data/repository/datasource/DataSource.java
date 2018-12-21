package com.example.javier.teamworkapp.data.repository.datasource;

import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import io.reactivex.Observable;



public interface DataSource {
    Observable<ProjectEntity> getProjectEntity();
}
