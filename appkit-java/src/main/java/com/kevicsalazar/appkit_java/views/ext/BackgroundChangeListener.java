package com.kevicsalazar.appkit_java.views.ext;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by Kevin Salazar
 */
public class BackgroundChangeListener implements ViewPager.OnPageChangeListener {

    private List<Integer> colors;
    private ViewPager viewPager;

    private ArgbEvaluator argbEvaluator;

    public BackgroundChangeListener(List<Integer> colors, ViewPager viewPager) {
        this.colors = colors;
        this.viewPager = viewPager;
        this.argbEvaluator = new ArgbEvaluator();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position < (colors.size() - 1)) {
            viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors.get(position), colors.get(position + 1)));
        } else {
            viewPager.setBackgroundColor(colors.get(colors.size() - 1));
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
