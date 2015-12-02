package com.kevicsalazar.appkit_android.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.mvp.model.Project;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class ParagraphRecyclerBinder extends RecyclerBinder<BinderViewType> {

    private final Project project;

    public ParagraphRecyclerBinder(Activity activity, Project project) {
        super(activity, BinderViewType.PARAGRAPH);
        this.project = project;
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
        holder.tvParagraph.setText(project.getDescription());
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
