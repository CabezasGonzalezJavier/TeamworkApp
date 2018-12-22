package com.example.javier.teamworkapp.data.repositiory;

import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import com.example.javier.teamworkapp.data.entity.data.FakeRemoteAPI;
import com.example.javier.teamworkapp.data.remote.RemoteApi;
import com.example.javier.teamworkapp.data.remote.RemoteApiTest;
import com.example.javier.teamworkapp.data.repository.datasource.RemoteApiDataSource;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

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
    public void verifyGetProject() {
        remoteApiDataSource.getProjectEntity();

        verify(remoteApi).getProjectEntity("");
    }

    @Test
    public void givenAnObservableGetProjectEntity(){
        ProjectEntity projectEntityList =  FakeRemoteAPI.getProject();
        Observable<ProjectEntity> fakeObservable = Observable.just(projectEntityList);
        given(remoteApi.getProjectEntity("")).willReturn(fakeObservable);
    }

}
