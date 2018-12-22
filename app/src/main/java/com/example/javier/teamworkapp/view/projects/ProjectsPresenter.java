package com.example.javier.teamworkapp.view.projects;

import com.example.javier.teamworkapp.domain.model.ProjectDomain;
import com.example.javier.teamworkapp.domain.usecases.GetProjects;
import com.example.javier.teamworkapp.view.base.BasePresenter;
import com.example.javier.teamworkapp.view.viewmodel.ProjectViewModel;
import com.example.javier.teamworkapp.view.viewmodel.ProjectViewModelToProjectDomainMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class ProjectsPresenter extends BasePresenter<ProjectsPresenter.View> {

    GetProjects getProjects;
    ProjectViewModelToProjectDomainMapper mapper;

    @Inject
    public ProjectsPresenter(GetProjects getProjects,
                             ProjectViewModelToProjectDomainMapper mapper) {
        this.getProjects = getProjects;
        this.mapper = mapper;
    }

    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        getProjects.execute(new DisposableObserver<List<ProjectDomain>>() {
            @Override
            public void onNext(List<ProjectDomain> projectDomains) {
                List<ProjectViewModel> list = mapper.reverseMap(projectDomains);
                getView().showProjects(list);
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }

    public interface View extends BasePresenter.View {

        void showProjects(List<ProjectViewModel> teamList);
    }
}
