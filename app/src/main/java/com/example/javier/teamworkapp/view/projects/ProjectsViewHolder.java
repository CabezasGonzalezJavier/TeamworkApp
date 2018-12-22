package com.example.javier.teamworkapp.view.projects;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.javier.teamworkapp.R;
import com.example.javier.teamworkapp.view.viewmodel.ProjectViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.project_name_textView)
    TextView nameTextView;
    @BindView(R.id.project_imageView)
    ImageView image;

    ProjectsPresenter presenter;

    public ProjectsViewHolder(View itemView, ProjectsPresenter presenter) {
        super(itemView);
        this.presenter = presenter;
        ButterKnife.bind(this, itemView);
    }

    public void render(ProjectViewModel projectViewModel) {
        onItemClick(projectViewModel);
        renderImage(projectViewModel.getLogo());
        renderName(projectViewModel.getName());
    }

    private void renderName(String name) {
        nameTextView.setText(name);
    }

    private void renderImage(String urlHeaderImage) {
        getImage(urlHeaderImage, image);
    }

    private void getImage(String photo, ImageView photoImageView) {
        Glide.with(getContext()).load(photo).into(photoImageView);
    }

    private Context getContext() {
        return itemView.getContext();
    }

    private void onItemClick(final ProjectViewModel projectViewModel) {

    }
}
