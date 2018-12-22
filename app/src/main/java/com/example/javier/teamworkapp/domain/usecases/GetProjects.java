package com.example.javier.teamworkapp.domain.usecases;

import com.example.javier.teamworkapp.data.repository.Repository;
import com.example.javier.teamworkapp.domain.model.ProjectDomain;
import io.reactivex.Observable;
import io.reactivex.Scheduler;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public class GetProjects extends UseCase<List<ProjectDomain>> {
    private final Repository repository;

    @Inject
    public GetProjects(@Named("executor_thread") Scheduler executorThread,
                        @Named("ui_thread") Scheduler uiThread, Repository repository) {
        super(executorThread, uiThread);
        this.repository = repository;
    }


    @Override
    public Observable<List<ProjectDomain>> createObservableUseCase() {
        return repository.getProject();
    }
}
