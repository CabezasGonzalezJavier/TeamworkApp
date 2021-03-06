
package com.example.javier.teamworkapp.data.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectEntity {

    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("projects")
    @Expose
    private List<Project> projects = null;

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
