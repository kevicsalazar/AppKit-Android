package com.kevicsalazar.appkit_android.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
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
public class ParagraphRecyclerBinder extends RecyclerBinder<BinderViewType> {

    private final Item item;

    public ParagraphRecyclerBinder(Activity activity, Item item) {
        super(activity, BinderViewType.PARAGRAPH);
        this.item = item;
    }

    @Override
    public int layoutResId() {
        return R.layout.item_paragraph;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tvParagraph.setText(Html.fromHtml(item.getDescription()));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tvParagraph)
        TextView tvParagraph;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
