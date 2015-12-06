package com.kevicsalazar.appkit_android.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.mvp.model.Item;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class PortfolioRecyclerBinder extends RecyclerBinder<BinderViewType> {

    private final Item item;

    public PortfolioRecyclerBinder(Activity activity, Item item) {
        super(activity, BinderViewType.PORTFOLIO);
        this.item = item;
    }

    @Override
    public int layoutResId() {
        return R.layout.item_portfolio;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tvPeriod.setText(item.getPeriod());
        holder.tvTitle.setText(item.getTitle());
        holder.tvOcupation.setText(item.getOcupation());
        holder.tvDescription.setText(item.getDescription());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tvPeriod)
        TextView tvPeriod;
        @Bind(R.id.tvTitle)
        TextView tvTitle;
        @Bind(R.id.tvOcupation)
        TextView tvOcupation;
        @Bind(R.id.tvDescription)
        TextView tvDescription;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
