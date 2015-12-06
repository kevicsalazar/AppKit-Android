package com.kevicsalazar.appkit_android.ui.mvp.presenters;

import android.graphics.Color;
import android.support.v4.app.Fragment;

import com.kevicsalazar.appkit_android.cloud.ws.WebServiceItem;
import com.kevicsalazar.appkit_android.ui.mvp.model.Item;
import com.kevicsalazar.appkit_android.ui.mvp.views.IntroductionFragment;
import com.kevicsalazar.appkit_android.ui.mvp.views.PortfolioFragment;
import com.kevicsalazar.appkit_java.BasePresenter;
import com.kevicsalazar.appkit_java.enums.LoadStatus;
import com.kevicsalazar.appkit_java.interfaces.LoadCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class MainPresenter extends BasePresenter<MainPresenter.View> {

    private WebServiceItem wsp;

    public MainPresenter(WebServiceItem wsp) {
        this.wsp = wsp;
    }

    public void getListItems() {
        wsp.getListItems(new LoadCallback<List<Item>>() {
            @Override
            public void onLoadStatus(LoadStatus status) {

            }

            @Override
            public void onLoadSuccess(List<Item> itemList) {
                if (view != null) {
                    filterItemList(itemList);
                    createColor();
                }
            }

            @Override
            public void onLoadFailure(int resId) {

            }
        });
    }

    private void filterItemList(List<Item> itemList) {
        List<Item> introductionList = new ArrayList<>();
        List<Item> portfolioList = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getPosition() == 1) {
                introductionList.add(item);
            } else {
                portfolioList.add(item);
            }
        }
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(IntroductionFragment.newInstance(introductionList));
        fragmentList.add(PortfolioFragment.newInstance(portfolioList));
        view.setupViewPager(fragmentList);
    }

    private void createColor() {
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#00BCD4"));
        colors.add(Color.parseColor("#FFC107"));
        view.setColors(colors);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public interface View {

        void setupViewPager(List<Fragment> fragmentList);

        void setColors(List<Integer> colors);

    }

}
