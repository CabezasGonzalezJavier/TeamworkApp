package com.example.javier.teamworkapp.view.projects;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.javier.teamworkapp.ProjectApplication;
import com.example.javier.teamworkapp.R;
import com.example.javier.teamworkapp.view.base.BaseActivity;
import com.example.javier.teamworkapp.view.detail.DetailActivity;
import com.example.javier.teamworkapp.view.viewmodel.ProjectViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class ProjectsActivity extends BaseActivity implements ProjectsPresenter.View {

    @Inject
    ProjectsPresenter presenter;
    @BindView(R.id.project_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.project_progress)
    ProgressBar progressBar;


    private ProjectsAdapter adapter;
    @Override
    public void initView() {
        initializeDagger();
        initializePresenter();
        initializeAdapter();
        initializeRecyclerView();
        presenter.initialize();
    }
    private void initializeDagger() {
        ProjectApplication app = (ProjectApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializeAdapter() {
        adapter = new ProjectsAdapter(presenter);
    }

    private void initializeRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new android.support.v7.widget.DividerItemDecoration(this,
                android.support.v7.widget.DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.project_activity;
    }

    private void initializePresenter() {
        presenter.setView(this);
    }

    @Override
    public void showProjects(List<ProjectViewModel> list) {
        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openProjectScreen(ProjectViewModel projectViewModel) {
        DetailActivity.open(ProjectsActivity.this,
                projectViewModel.getName(),
                projectViewModel.getLogo(),
                projectViewModel.getDescription(),
                projectViewModel.getCreate(),
                projectViewModel.getStart(),
                projectViewModel.getEnd(),
                projectViewModel.getLastChange(),
                projectViewModel.getStatus());
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
