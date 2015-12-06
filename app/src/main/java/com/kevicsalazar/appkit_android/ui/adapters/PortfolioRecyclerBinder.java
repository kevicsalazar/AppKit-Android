package com.kevicsalazar.appkit_android.ui.adapters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.mvp.model.Item;
import com.wnafee.vector.compat.ResourcesCompat;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class PortfolioRecyclerBinder extends RecyclerBinder<BinderViewType> {

    private Activity activity;
    private final Item item;

    public PortfolioRecyclerBinder(Activity activity, Item item) {
        super(activity, BinderViewType.PORTFOLIO);
        this.activity = activity;
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
        if (!item.getMarker().isEmpty()) {
            holder.tvMarker.setText(item.getMarker());
            holder.tvMarker.setVisibility(View.VISIBLE);
        } else {
            holder.tvMarker.setVisibility(View.GONE);
        }
        if (!item.getLink().isEmpty()) {
            holder.ivLink.setImageDrawable(ResourcesCompat.getDrawable(activity, R.drawable.ic_link_variant));
            holder.ivLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(item.getLink()));
                    activity.startActivity(intent);
                }
            });
            holder.ivLink.setVisibility(View.VISIBLE);
        } else {
            holder.ivLink.setVisibility(View.GONE);
        }

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
        @Bind(R.id.tvMarker)
        TextView tvMarker;
        @Bind(R.id.ivLink)
        ImageView ivLink;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
