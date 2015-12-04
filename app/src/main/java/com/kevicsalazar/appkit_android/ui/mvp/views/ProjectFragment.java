package com.kevicsalazar.appkit_android.ui.mvp.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kevicsalazar.appkit_android.Initializer;
import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.adapters.BinderAdapter;
import com.kevicsalazar.appkit_android.ui.adapters.BinderSection;
import com.kevicsalazar.appkit_android.ui.adapters.ParagraphRecyclerBinder;
import com.kevicsalazar.appkit_android.ui.mvp.model.Project;
import com.kevicsalazar.appkit_java.BaseFragment;
import com.kevicsalazar.appkit_java.BasePresenter;
import com.kevicsalazar.appkit_java.utils.NestedLinearLayoutManager;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class ProjectFragment extends BaseFragment {

    @Inject
    BinderAdapter binderAdapter;

    @Bind(R.id.ivMockup1)
    ImageView ivMockup1;
    @Bind(R.id.recycler)
    RecyclerView recycler;

    public static Fragment newInstance(Project project) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("project", Parcels.wrap(project));
        Fragment fragment = new ProjectFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Project project = Parcels.unwrap(getArguments().getParcelable("project"));
        Glide.with(this).load(project.getImageUrl()).into(ivMockup1);
        setupRecyclerView(recycler);
        addItemsToAdapter(project);
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
        Initializer.init(getActivity()).inject(this);
    }

    private void setupRecyclerView(RecyclerView recycler) {
        recycler.setLayoutManager(new NestedLinearLayoutManager(getContext()));
        recycler.setAdapter(binderAdapter);
        recycler.setHasFixedSize(false);
    }

    private void addItemsToAdapter(Project project) {
        binderAdapter.add(BinderSection.PORTFOLIO, new ParagraphRecyclerBinder(getActivity(), project));
        binderAdapter.add(BinderSection.PORTFOLIO, new ParagraphRecyclerBinder(getActivity(), project));
        binderAdapter.add(BinderSection.PORTFOLIO, new ParagraphRecyclerBinder(getActivity(), project));
        binderAdapter.add(BinderSection.PORTFOLIO, new ParagraphRecyclerBinder(getActivity(), project));
    }

}
