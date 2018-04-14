package com.nytimes.demo.nytimes.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nytimes.demo.nytimes.R;
import com.nytimes.demo.nytimes.news.models.Result;


import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<Result> data;
    private Context context;

    public NewsAdapter(Context context, List<Result> data, OnItemClickListener listener) {
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
        holder.tvCity.setText(data.get(position).getTitle());
        holder.tvDesc.setText(data.get(position).getAbstract());

        String images = null;
        if (data.get(position).getMultimedia().size() > 0) {
            images = data.get(position).getMultimedia().get(0).getUrl();

            Glide.with(context)
                    .load(images)

               /* .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)*/
                    .into(holder.background);
        }

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(Result Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity, tvDesc;
        ImageView background;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = (TextView) itemView.findViewById(R.id.city);
            tvDesc = (TextView) itemView.findViewById(R.id.hotel);
            background = (ImageView) itemView.findViewById(R.id.image);

        }


        public void click(final Result result, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(result);
                }
            });
        }
    }


}
