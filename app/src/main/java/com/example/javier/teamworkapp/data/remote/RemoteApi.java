package com.example.javier.teamworkapp.data.remote;

import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RemoteApi {

    @GET("projects.json/")
    Observable<ProjectEntity> getProjectEntity(@Header("Authorization") String authkey);
}
