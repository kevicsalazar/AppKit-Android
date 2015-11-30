package com.kevicsalazar.appkit_android.ui.mvp.views;

import android.os.Bundle;

import com.kevicsalazar.appkit_android.Initializer;
import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.adapters.BinderAdapter;
import com.kevicsalazar.appkit_android.ui.mvp.model.Project;
import com.kevicsalazar.appkit_android.ui.mvp.presenters.MainPresenter;
import com.kevicsalazar.appkit_java.BaseActivity;
import com.kevicsalazar.appkit_java.BasePresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenter.View {

    @Inject
    MainPresenter mainPresenter;
    @Inject
    BinderAdapter binderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter.view = this;
        mainPresenter.getListProjects();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    protected void setupComponent() {
        Initializer.init(this).inject(this);
    }

    @Override
    public void clearAdapter() {
        binderAdapter.clear();
    }

    @Override
    public void addProjectListToAdapter(List<Project> projectList) {

    }

}
