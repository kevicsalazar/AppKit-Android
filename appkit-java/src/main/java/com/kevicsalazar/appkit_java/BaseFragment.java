package com.kevicsalazar.appkit_java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Kevin Salazar
 */
public abstract class BaseFragment extends Fragment {

    protected AppCompatActivity getAppCompatActivity() {
        if (getActivity() instanceof AppCompatActivity) {
            return (AppCompatActivity) getActivity();
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupComponent();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getPresenter() != null) getPresenter().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) getPresenter().onStop();
    }

    protected void setupActionBar(Toolbar toolbar) {
        if (getAppCompatActivity() != null) {
            getAppCompatActivity().setSupportActionBar(toolbar);
            assert getAppCompatActivity().getSupportActionBar() != null;
            getAppCompatActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void setTitle(int resId) {
        if (getAppCompatActivity() != null) {
            getAppCompatActivity().setTitle(resId);
        }
    }

    /**
     * @return The layout that's gonna be the activity view.
     */
    protected abstract int getLayout();

    /**
     * @return The presenter attached to the activity. This must extends from [BasePresenter]
     */
    protected abstract BasePresenter getPresenter();

    /**
     * Setup UIComponent
     */
    protected abstract void setupComponent();

}
