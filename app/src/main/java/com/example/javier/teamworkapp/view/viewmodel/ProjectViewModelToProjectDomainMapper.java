package com.example.javier.teamworkapp.view.viewmodel;


import com.example.javier.teamworkapp.Utils;
import com.example.javier.teamworkapp.data.repository.datasource.mapper.Mapper;
import com.example.javier.teamworkapp.domain.model.ProjectDomain;

import javax.inject.Inject;

public class ProjectViewModelToProjectDomainMapper extends Mapper<ProjectViewModel, ProjectDomain> {

    @Inject
    ProjectViewModelToProjectDomainMapper() {
    }

    @Override
    public ProjectDomain map(ProjectViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProjectViewModel reverseMap(ProjectDomain value) {

        ProjectViewModel projectViewModel = new ProjectViewModel();
        projectViewModel.setName(value.getName());
        projectViewModel.setDescription(value.getDescription());
        projectViewModel.setLogo(value.getLogo());
        projectViewModel.setStart(value.getStart());
        projectViewModel.setEnd(value.getEnd());
        projectViewModel.setCreate(value.getCreate());
        projectViewModel.setLastChange(value.getLastChange());

        return projectViewModel;
    }
}
