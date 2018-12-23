package com.example.javier.teamworkapp.view.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.javier.teamworkapp.R;
import com.example.javier.teamworkapp.view.base.BaseActivity;

import butterknife.BindView;

public class DetailActivity extends BaseActivity {
    private final static String PROJECT_NAME_KEY = "project_key";
    private final static String PROJECT_LOGO_KEY = "project_logo_key";
    private final static String PROJECT_DES_KEY = "project_des_key";
    private final static String PROJECT_CREATE_KEY = "project_create_key";
    private final static String PROJECT_START_KEY = "project_start_key";
    private final static String PROJECT_END_KEY = "project_end_key";
    private final static String PROJECT_LAST_KEY = "project_last_key";
    private final static String PROJECT_STATUS_KEY = "project_status_key";

    public static void open(Context context,
                            String name,
                            String logo,
                            String description,
                            String create,
                            String start,
                            String end,
                            String last,
                            String status) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(PROJECT_NAME_KEY, name);
        intent.putExtra(PROJECT_LOGO_KEY, logo);
        intent.putExtra(PROJECT_DES_KEY, description);
        intent.putExtra(PROJECT_CREATE_KEY, create);
        intent.putExtra(PROJECT_START_KEY, start);
        intent.putExtra(PROJECT_END_KEY, end);
        intent.putExtra(PROJECT_LAST_KEY, last);
        intent.putExtra(PROJECT_STATUS_KEY, status);
        context.startActivity(intent);
    }
    @BindView(R.id.detail_activity_toolbar)
    Toolbar title;

    @BindView(R.id.detail_toolbar_image_view)
    ImageView toolbarImageView;

    @BindView(R.id.detail_description)
    TextView descriptionTextView;

    @BindView(R.id.detail_create)
    TextView createTextView;

    @BindView(R.id.detail_start)
    TextView startTextView;

    @BindView(R.id.detail_end)
    TextView endTextView;

    @BindView(R.id.detail_last)
    TextView lastTextView;

    @BindView(R.id.detail_status)
    TextView statusTextView;

    @Override
    public void initView() {
        String name = getIntent().getStringExtra(PROJECT_NAME_KEY);
        String logo = getIntent().getStringExtra(PROJECT_LOGO_KEY);
        String description = getIntent().getStringExtra(PROJECT_DES_KEY);
        String start = getIntent().getStringExtra(PROJECT_START_KEY);
        String create = getIntent().getStringExtra(PROJECT_CREATE_KEY);
        String end = getIntent().getStringExtra(PROJECT_END_KEY);
        String last = getIntent().getStringExtra(PROJECT_LAST_KEY);
        String status = getIntent().getStringExtra(PROJECT_STATUS_KEY);
        setSupportActionBar(title);
        getSupportActionBar().setTitle(name);
        Glide.with(this).load(logo).into(toolbarImageView);
        descriptionTextView.setText(description);
        startTextView.setText(start);
        createTextView.setText(create);
        endTextView.setText(end);
        lastTextView.setText(last);
        statusTextView.setText(status);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.detail_activity;
    }
}
