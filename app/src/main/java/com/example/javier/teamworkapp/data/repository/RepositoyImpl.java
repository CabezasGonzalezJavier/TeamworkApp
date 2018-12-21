package com.example.javier.teamworkapp.data.repository;

import com.example.javier.teamworkapp.data.repository.datasource.DataSource;
import com.example.javier.teamworkapp.data.repository.datasource.mapper.ProjectDomainToProjectEntityMapper;
import com.example.javier.teamworkapp.domain.model.ProjectDomain;
import io.reactivex.Observable;

public class RepositoyImpl implements Repository {
    private final DataSource dataSource;
    private final ProjectDomainToProjectEntityMapper projectDomainToProjectMapper;

    public RepositoyImpl(DataSource dataSource, ProjectDomainToProjectEntityMapper projectDomainToProjectMapper) {
        this.dataSource = dataSource;
        this.projectDomainToProjectMapper = projectDomainToProjectMapper;
    }

    @Override
    public Observable<ProjectDomain> getProject() {
        return dataSource.getProjectEntity().map(projectDomainToProjectMapper::reverseMap);
    }
}
