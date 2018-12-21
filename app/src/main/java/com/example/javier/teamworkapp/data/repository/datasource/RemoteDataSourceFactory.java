package com.example.javier.teamworkapp.data.repository.datasource;

import com.example.javier.teamworkapp.data.remote.RemoteImpl;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Inject;

public class RemoteDataSourceFactory {

    public static final String URL_BASE = "https://yat.teamwork.com/";
    @Inject
    public RemoteDataSourceFactory(){

    }

    public DataSource createDataSource() {
        RemoteImpl remote = new RemoteImpl(new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build());
        return new RemoteApiDataSource(remote);

    }
}
