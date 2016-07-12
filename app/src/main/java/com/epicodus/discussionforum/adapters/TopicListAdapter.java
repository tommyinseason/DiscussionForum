package com.epicodus.discussionforum.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.model.Topic;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.TopicListViewHolder> {
    private ArrayList<Topic> mTopics = new ArrayList<>();
    private Context mContext;
    private TextView mTopicNameTextView;

    public TopicListAdapter(Context context, ArrayList<Topic> topics) {
        mContext = context;
        mTopics = topics;
    }

    @Override
    public TopicListAdapter.TopicListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_list_item, parent, false);
        TopicListViewHolder viewHolder = new TopicListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TopicListAdapter.TopicListViewHolder holder, int position) {
        holder.bindTopic(mTopics.get(position));
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    public class TopicListViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.topicNameTextView) TextView mTopicNameTextView;

        private Context mContext;

        public TopicListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindTopic(Topic topic) {
            mTopicNameTextView.setText(topic.getTopicName());
        }
    }
}
