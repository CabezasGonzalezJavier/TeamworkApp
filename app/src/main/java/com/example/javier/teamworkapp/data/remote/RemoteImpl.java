package com.example.javier.teamworkapp.data.remote;

import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import javax.inject.Inject;

public class RemoteImpl implements RemoteApi {
    Retrofit retrofit;
    private RemoteApi remoteApi;

    @Inject
    public RemoteImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
        remoteApi = retrofit.create(RemoteApi.class);
    }

    @Override
    public Observable<ProjectEntity> getProjectEntity() {
        return  Observable.create(emitter ->
                remoteApi.getProjectEntity().subscribeOn(Schedulers.io())
                        .cache()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableObserver<ProjectEntity>() {
                            @Override
                            public void onNext(ProjectEntity projectEntity) {
                                emitter.onNext(projectEntity);
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
