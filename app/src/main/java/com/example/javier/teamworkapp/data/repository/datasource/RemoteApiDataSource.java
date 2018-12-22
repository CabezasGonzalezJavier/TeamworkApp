package com.example.javier.teamworkapp.data.repository.datasource;

import android.util.Base64;
import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import com.example.javier.teamworkapp.data.remote.RemoteApi;
import io.reactivex.Observable;

import java.io.UnsupportedEncodingException;

import static com.example.javier.teamworkapp.Constants.API_PASSWORD;
import static com.example.javier.teamworkapp.Constants.API_USER_NAME;

public class RemoteApiDataSource implements DataSource {

    private final RemoteApi remoteApi;

    public RemoteApiDataSource(RemoteApi remoteApi) {
        this.remoteApi = remoteApi;
    }

    @Override
    public Observable<ProjectEntity> getProjectEntity() {
        return remoteApi.getProjectEntity(getAuthStringUser());
    }

    private static String getAuthStringUser() {
        byte[] data = new byte[0];
        try {
            data = (API_USER_NAME + ":" + API_PASSWORD).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}
