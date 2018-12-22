package com.example.javier.teamworkapp.data.repository.datasource;

import com.example.javier.teamworkapp.Utils;
import com.example.javier.teamworkapp.data.entity.Project;
import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import com.example.javier.teamworkapp.data.remote.RemoteApi;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class RemoteApiDataSource implements DataSource {

    private final RemoteApi remoteApi;

    public RemoteApiDataSource(RemoteApi remoteApi) {
        this.remoteApi = remoteApi;
    }

    @Override
    public Observable<List<Project>> getProjectEntity() {
        return Observable.create(emitter ->
                remoteApi.getProjectEntity(Utils.getAuthStringUser()).subscribeOn(Schedulers.io())
                .cache()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ProjectEntity>() {
                    @Override
                    public void onNext(ProjectEntity projectEntity) {
                        emitter.onNext(projectEntity.getProjects());
                    }
                    @Override
                        public void onError(Throwable e) {
                            emitter.onError(e);
                        }

                        @Override
                        public void onComplete() {
                            emitter.onComplete();
                        }
                    }));
    }

}
