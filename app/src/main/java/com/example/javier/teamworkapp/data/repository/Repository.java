package com.example.javier.teamworkapp.data.repository;

import com.example.javier.teamworkapp.domain.model.ProjectDomain;
import io.reactivex.Observable;

import java.util.List;


public interface Repository {

    Observable<List<ProjectDomain>> getProject();
}
