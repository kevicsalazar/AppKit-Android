package com.kevicsalazar.appkit_android.ui.mvp.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.mvp.model.Project;
import com.kevicsalazar.appkit_java.BaseFragment;
import com.kevicsalazar.appkit_java.BasePresenter;

import butterknife.Bind;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class ProjectFragment extends BaseFragment {

    @Bind(R.id.wrapper)
    View wrapper;

    public static Fragment newInstance(Project project) {
        Bundle bundle = new Bundle();
        bundle.putInt("color", project.getColor());
        Fragment fragment = new ProjectFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wrapper.setBackgroundColor(getArguments().getInt("color"));
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_project;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void setupComponent() {

    }

}
