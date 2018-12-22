package com.example.javier.teamworkapp.view.viewmodel;


import com.example.javier.teamworkapp.data.repository.datasource.mapper.Mapper;
import com.example.javier.teamworkapp.domain.model.ProjectDomain;

public class ProjectViewModelToProjectDomainMapper extends Mapper<ProjectViewModel, ProjectDomain> {
    @Override
    public ProjectDomain map(ProjectViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProjectViewModel reverseMap(ProjectDomain value) {
        return null;
    }
}
