package com.example.javier.teamworkapp.data.repository.datasource.mapper;

import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import com.example.javier.teamworkapp.domain.model.ProjectDomain;
import com.example.javier.teamworkapp.domain.model.SortProject;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ProjectDomainToProjectEntityMapper extends Mapper<ProjectDomain, ProjectEntity>{

    @Inject
    public ProjectDomainToProjectEntityMapper(){

    }

    @Override
    public ProjectEntity map(ProjectDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProjectDomain reverseMap(ProjectEntity value) {

        ProjectDomain projectDomain = new ProjectDomain();
        projectDomain.setStatus(value.getSTATUS());
        List<SortProject> list = new ArrayList<>();
        for (int i=0; i<value.getProjects().size(); i++) {
            SortProject sortProject = new SortProject();
            sortProject.setName(value.getProjects().get(i).getName());
            sortProject.setDescription(value.getProjects().get(i).getDescription());
            sortProject.setLogo(value.getProjects().get(i).getLogo());
            sortProject.setStart(value.getProjects().get(i).getStartDate());
            sortProject.setEnd(value.getProjects().get(i).getEndDate());
            sortProject.setCreate(value.getProjects().get(i).getCreatedOn());
            sortProject.setLastChange(value.getProjects().get(i).getLastChangedOn());
            list.add(sortProject);
        }
        projectDomain.setSortProjectList(list);
        return projectDomain;
    }


}
