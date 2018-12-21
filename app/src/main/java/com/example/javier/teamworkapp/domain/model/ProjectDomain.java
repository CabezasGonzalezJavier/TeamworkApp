package com.example.javier.teamworkapp.domain.model;

import java.util.List;

public class ProjectDomain {
    private String status;
    private List<SortProject> sortProjectList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SortProject> getSortProjectList() {
        return sortProjectList;
    }

    public void setSortProjectList(List<SortProject> sortProjectList) {
        this.sortProjectList = sortProjectList;
    }
}
