package com.nytimes.demo.nytimes.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nytimes.demo.nytimes.R;
import com.nytimes.demo.nytimes.activeandroidPojo.ResultPojo;


import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<ResultPojo> data;
    private Context context;

    public NewsAdapter(Context context, List<ResultPojo> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }


    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.title.setText(data.get(position).getTitle());

        String images = null;
        if (data.get(position).getMultimedia().size() > 0) {
            images = data.get(position).getMultimedia().get(0).getUrl();

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.mipmap.ic_launcher);
            requestOptions.error(R.mipmap.ic_launcher);
            Glide.with(context)
                     .setDefaultRequestOptions(requestOptions)
                    .load(images)
                    .into(holder.background);
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener {
        void onClick(ResultPojo Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView background;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            background = (ImageView) itemView.findViewById(R.id.image);
        }


        public void click(final ResultPojo result, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(result);
                }
            });
        }
    }

}
