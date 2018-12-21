package com.example.javier.teamworkapp.data.repository.datasource;

import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import com.example.javier.teamworkapp.data.remote.RemoteApi;
import io.reactivex.Observable;

public class RemoteApiDataSource implements DataSource {

    private final RemoteApi remoteApi;

    public RemoteApiDataSource(RemoteApi remoteApi) {
        this.remoteApi = remoteApi;
    }

    @Override
    public Observable<ProjectEntity> getProjectEntity() {
        return remoteApi.getProjectEntity();
    }
}
