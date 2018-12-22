package com.example.javier.teamworkapp.view.projects;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.teamworkapp.R;
import com.example.javier.teamworkapp.view.viewmodel.ProjectViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ProjectsPresenter presenter;
    private final List<ProjectViewModel> list;

    public ProjectsAdapter(ProjectsPresenter presenter) {
        this.presenter = presenter;
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.projects_row, viewGroup, false);
        return new ProjectsViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ProjectsViewHolder projectsViewHolder = (ProjectsViewHolder) viewHolder;
        ProjectViewModel projectViewModel = list.get(i);
        projectsViewHolder.render(projectViewModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(Collection<ProjectViewModel> collection) {
        list.addAll(collection);
    }

}
