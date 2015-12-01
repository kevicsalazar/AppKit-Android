package com.kevicsalazar.appkit_android.utils;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.kevicsalazar.appkit_android.R;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class CrossfadePageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();

        View backgroundView = page.findViewById(R.id.wrapper);

        if (position <= 1) {
            page.setTranslationX(pageWidth * -position);
        }

        if (position <= -1.0f || position >= 1.0f) {

        } else if (position == 0.0f) {

        } else {
            if (backgroundView != null) {
                backgroundView.setAlpha(1.0f - Math.abs(position));
            }
        }

    }

}
