package com.example.javier.teamworkapp.data.repository;

import com.example.javier.teamworkapp.domain.model.ProjectDomain;
import io.reactivex.Observable;


public interface Repository {

    Observable<ProjectDomain> getProject();
}
