package com.kevicsalazar.appkit_android.ui.mvp.views;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.kevicsalazar.appkit_android.Initializer;
import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.mvp.model.Project;
import com.kevicsalazar.appkit_android.ui.mvp.presenters.MainPresenter;
import com.kevicsalazar.appkit_java.BaseActivity;
import com.kevicsalazar.appkit_java.BasePresenter;
import com.kevicsalazar.appkit_java.adapters.SimplePagerAdapter;
import com.kevicsalazar.appkit_java.views.ext.BackgroundChangeListener;
import com.kevicsalazar.appkit_java.views.ext.ParallaxPageTransformer;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainPresenter.View {

    @Inject
    MainPresenter mainPresenter;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    ParallaxPageTransformer pageTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled(true);

        pageTransformer = new ParallaxPageTransformer()
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.ivMockup1, -0.5f, -5f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.ivMockup2, -1f, -10f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.recycler, -2f, -2f));

        mainPresenter.getListProjects();

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mainPresenter.with(this);
    }

    @Override
    protected void setupComponent() {
        Initializer.init(this).inject(this);
    }

    @Override
    public void addProjectListToAdapter(List<Project> projectList) {
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());
        for (Project project : projectList) {
            adapter.addFragment(ProjectFragment.newInstance(project));
        }
        viewPager.setPageTransformer(true, pageTransformer);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void setColors(List<Integer> colors) {
        viewPager.addOnPageChangeListener(new BackgroundChangeListener(colors, viewPager));
    }

}
