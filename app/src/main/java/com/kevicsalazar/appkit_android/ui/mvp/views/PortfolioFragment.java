package com.kevicsalazar.appkit_android.ui.mvp.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kevicsalazar.appkit_android.Initializer;
import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.adapters.BinderAdapter;
import com.kevicsalazar.appkit_android.ui.adapters.BinderSection;
import com.kevicsalazar.appkit_android.ui.adapters.PortfolioRecyclerBinder;
import com.kevicsalazar.appkit_android.ui.mvp.model.Item;
import com.kevicsalazar.appkit_java.BaseFragment;
import com.kevicsalazar.appkit_java.BasePresenter;
import com.kevicsalazar.appkit_java.utils.NestedLinearLayoutManager;
import com.wnafee.vector.compat.ResourcesCompat;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class PortfolioFragment extends BaseFragment {

    @Inject
    BinderAdapter binderAdapter;

    @Bind(R.id.ivMac)
    ImageView ivMac;
    @Bind(R.id.ivAndroid)
    ImageView ivAndroid;
    @Bind(R.id.recycler)
    RecyclerView recycler;

    public static Fragment newInstance(List<Item> itemList) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("itemList", Parcels.wrap(itemList));
        Fragment fragment = new PortfolioFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Item> itemList = Parcels.unwrap(getArguments().getParcelable("itemList"));

        ivMac.setImageDrawable(ResourcesCompat.getDrawable(getContext(), R.drawable.image_mac));
        ivAndroid.setImageDrawable(ResourcesCompat.getDrawable(getContext(), R.drawable.image_android));

        setupRecyclerView(recycler);
        addItemsToAdapter(itemList);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_portfolio;
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

    private void addItemsToAdapter(List<Item> itemList) {
        for (Item item : itemList) {
            binderAdapter.add(BinderSection.PORTFOLIO, new PortfolioRecyclerBinder(getActivity(), item));
        }
    }

}
