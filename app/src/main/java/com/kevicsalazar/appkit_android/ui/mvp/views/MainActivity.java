package com.kevicsalazar.appkit_android.ui.mvp.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.kevicsalazar.appkit_android.Initializer;
import com.kevicsalazar.appkit_android.R;
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

        pageTransformer = new ParallaxPageTransformer()
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.ivMac, -0.5f, -5f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.ivAndroid, -1f, -10f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.ivBooks, -0.5f, -5f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.ivHuman, -1f, -10f))
                .addViewToParallax(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.recycler, -2f, -2f));

        mainPresenter.getListItems();

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
    public void setupViewPager(List<Fragment> fragmentList) {
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setPageTransformer(true, pageTransformer);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void setColors(List<Integer> colors) {
        viewPager.addOnPageChangeListener(new BackgroundChangeListener(colors, viewPager));
    }

}
