package com.example.javier.teamworkapp.data.repository.datasource.mapper;

import com.example.javier.teamworkapp.Utils;
import com.example.javier.teamworkapp.data.entity.Project;
import com.example.javier.teamworkapp.domain.model.ProjectDomain;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectDomainToProjectEntityMapper extends Mapper<ProjectDomain, Project> {

    @Inject
    public ProjectDomainToProjectEntityMapper() {
    }

    @Override
    public Project map(ProjectDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProjectDomain reverseMap(Project value) {
        ProjectDomain projectDomain = new ProjectDomain();
        projectDomain.setName(value.getName());
        projectDomain.setDescription(value.getDescription());
        projectDomain.setLogo(value.getLogo());
        projectDomain.setStart(Utils.convertTimeStampToString(value.getStartDate()));
        projectDomain.setEnd(Utils.convertTimeStampToString(value.getEndDate()));
        projectDomain.setCreate(Utils.convertStringDateToString(value.getCreatedOn()));
        projectDomain.setLastChange(Utils.convertStringDateToString(value.getLastChangedOn()));

        return projectDomain;
    }
}
