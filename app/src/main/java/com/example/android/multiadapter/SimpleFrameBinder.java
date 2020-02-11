package com.example.android.multiadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.drakeet.multitype.ItemViewBinder;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * created by zyh
 * on 2019-10-11
 */
public abstract class SimpleFrameBinder<Content extends SimpleContent, SubViewHolder extends ContentHolder>
        extends ItemViewBinder<SimpleData, SimpleFrameBinder.FrameHolder> {

    protected abstract ContentHolder onCreateContentViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    protected abstract void onBindContentViewHolder(@NonNull SubViewHolder holder, @NonNull Content content);


    @Override
    protected @NonNull FrameHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_frame, parent, false);
        ContentHolder subViewHolder = onCreateContentViewHolder(inflater, parent);
        return new FrameHolder(root, subViewHolder, this);
    }


    @Override @SuppressWarnings("unchecked")
    protected void onBindViewHolder(@NonNull FrameHolder holder, @NonNull SimpleData data) {
        holder.avatar.setImageResource(data.user.avatar);
        holder.username.setText(data.user.name);
        holder.createTime.setText(data.createTime);
        final SimpleContent content = data.content;
        onBindContentViewHolder((SubViewHolder) holder.subViewHolder, (Content) content);
    }


    static class FrameHolder extends RecyclerView.ViewHolder {

        private ImageView avatar;
        private TextView username;
        private FrameLayout container;
        private TextView createTime;
        private TextView close;
        private ContentHolder subViewHolder;


        FrameHolder(@NonNull View itemView, @NonNull final ContentHolder subViewHolder, @NonNull final SimpleFrameBinder binder) {
            super(itemView);
            avatar = (ImageView) findViewById(R.id.avatar);
            username = (TextView) findViewById(R.id.username);
            container = (FrameLayout) findViewById(R.id.container);
            createTime = (TextView) findViewById(R.id.create_time);
            close = (TextView) findViewById(R.id.close);
            container.addView(subViewHolder.itemView);
            this.subViewHolder = subViewHolder;
            this.subViewHolder.frameHolder = this;

            itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), "Position: " + getAdapterPosition(), LENGTH_SHORT).show());
            close.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    binder.getAdapter().getItems().remove(position);
                    binder.getAdapter().notifyItemRemoved(position);
                }
            });
        }


        private View findViewById(int resId) {
            return itemView.findViewById(resId);
        }
    }
}
