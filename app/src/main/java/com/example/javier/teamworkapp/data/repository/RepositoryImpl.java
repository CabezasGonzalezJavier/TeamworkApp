package com.example.javier.teamworkapp.data.repository;

import com.example.javier.teamworkapp.data.repository.datasource.DataSource;
import com.example.javier.teamworkapp.data.repository.datasource.RemoteDataSourceFactory;
import com.example.javier.teamworkapp.data.repository.datasource.mapper.ProjectDomainToProjectEntityMapper;
import com.example.javier.teamworkapp.domain.model.ProjectDomain;
import io.reactivex.Observable;

import java.util.List;

import javax.inject.Inject;

public class RepositoryImpl implements Repository {
    private final DataSource dataSource;
    private final ProjectDomainToProjectEntityMapper projectDomainToProjectMapper;

    @Inject
    public RepositoryImpl(RemoteDataSourceFactory remoteDataSourceFactory, ProjectDomainToProjectEntityMapper projectDomainToProjectMapper) {

        this.projectDomainToProjectMapper = projectDomainToProjectMapper;
        this.dataSource = remoteDataSourceFactory.createDataSource();
    }

    @Override
    public Observable<List<ProjectDomain>> getProject() {
        return dataSource.getProjectEntity().map(projectDomainToProjectMapper::reverseMap);
    }
}
