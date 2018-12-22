package com.example.javier.teamworkapp.data.repositiory;

import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import com.example.javier.teamworkapp.data.entity.data.FakeRemoteAPI;
import com.example.javier.teamworkapp.data.remote.RemoteApi;
import com.example.javier.teamworkapp.data.remote.RemoteApiTest;
import com.example.javier.teamworkapp.data.repository.datasource.RemoteApiDataSource;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class RemoteApiDataSourceTest {
    @Mock
    RemoteApi remoteApi;

    RemoteApiDataSource remoteApiDataSource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        remoteApiDataSource = new RemoteApiDataSource(remoteApi);
    }

    @Test
    public void givenAnObservableGetProjectEntity(){
        ProjectEntity projectEntityList =  FakeRemoteAPI.getProjectEntity();
        Observable<ProjectEntity> fakeObservable = Observable.just(projectEntityList);
        given(remoteApi.getProjectEntity("")).willReturn(fakeObservable);
    }

}
