package com.kevicsalazar.appkit_android.ui.mvp.views;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.kevicsalazar.appkit_android.Initializer;
import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.mvp.model.Project;
import com.kevicsalazar.appkit_android.ui.mvp.presenters.MainPresenter;
import com.kevicsalazar.appkit_android.utils.CrossfadePageTransformer;
import com.kevicsalazar.appkit_java.BaseActivity;
import com.kevicsalazar.appkit_java.BasePresenter;
import com.kevicsalazar.appkit_java.adapters.SimplePagerAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainPresenter.View {

    @Inject
    MainPresenter mainPresenter;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    boolean isOpaque = true;

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
    public void addProjectListToAdapter(final List<Project> projectList) {
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());
        for (Project project : projectList) {
            adapter.addFragment(ProjectFragment.newInstance(project));
        }
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new CrossfadePageTransformer());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == projectList.size() - 2 && positionOffset > 0) {
                    if (isOpaque) {
                        viewPager.setBackgroundColor(Color.TRANSPARENT);
                        isOpaque = false;
                    }
                } else {
                    if (!isOpaque) {
                        viewPager.setBackgroundColor(Color.WHITE);
                        isOpaque = true;
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
