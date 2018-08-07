package com.buvanesh.task.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.buvanesh.task.R;
import com.buvanesh.task.databinding.ItemNewsFeedBinding;
import com.buvanesh.task.model.NewsFeedModel;

import java.util.List;

import okhttp3.internal.Util;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder>{
    List<NewsFeedModel.Row> mNewsFeedModel;
    Context context;

    /**
     * Constructor to get the object to load
     * @param newsFeedModel response body
     * */
    public NewsFeedAdapter(List<NewsFeedModel.Row> newsFeedModel){
        mNewsFeedModel = newsFeedModel;
    }

    @NonNull
    @Override
    public NewsFeedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        // Binding the inflator using data binding
        ItemNewsFeedBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_news_feed,viewGroup,false);
        return new NewsFeedViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedViewHolder newsFeedViewHolder, int i) {
        // set the objects to bind the data
        newsFeedViewHolder.itemNewsFeedBinding.setRow(mNewsFeedModel.get(i));
        String url = mNewsFeedModel.get(i).getImageHref();
        if(url!=null) {
            // Glide to load the image from url and to load the image lazy
            Glide.with(context)
                    .setDefaultRequestOptions(getRequestionOptions())
                    .load(Uri.parse(url))
                    .into(newsFeedViewHolder.itemNewsFeedBinding.imgFeeds);
        }
        // To update the data in the view
        newsFeedViewHolder.itemNewsFeedBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return mNewsFeedModel.size();
    }

    /**
     * Custom request options to show placeholder and
     * to show error image in case of exceptions.
    * */
    public RequestOptions getRequestionOptions(){

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_placeholder);
        requestOptions.error(R.drawable.ic_image_error);
        return requestOptions;
    }

    public static class NewsFeedViewHolder extends RecyclerView.ViewHolder{
            ItemNewsFeedBinding itemNewsFeedBinding;
        public NewsFeedViewHolder(ItemNewsFeedBinding binding) {
            super(binding.getRoot());
            itemNewsFeedBinding = binding;
        }
    }
}
