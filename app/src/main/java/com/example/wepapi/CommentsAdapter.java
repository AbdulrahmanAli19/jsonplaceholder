package com.example.wepapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    class CommentsViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmail, tvName, tvBody;
        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBody = itemView.findViewById(R.id.tv_body);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    private Context mContext;
    private List<Comment> comments;

    public CommentsAdapter(Context mContext, List<Comment> comments) {
        this.mContext = mContext;
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.comment_view_holder, parent, false);
        CommentsViewHolder viewHolder = new CommentsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        Comment currentComment = comments.get(position);
        holder.tvName.setText(currentComment.getName());
        holder.tvEmail.setText(currentComment.getEmail());
        holder.tvBody.setText(currentComment.getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

}