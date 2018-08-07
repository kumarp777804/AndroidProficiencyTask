package com.buvanesh.task.view;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.buvanesh.task.R;
import com.buvanesh.task.adapter.NewsFeedAdapter;
import com.buvanesh.task.core.base.BaseActivity;
import com.buvanesh.task.databinding.ActivityNewsFeedBinding;
import com.buvanesh.task.model.NewsFeedModel;
import com.buvanesh.task.utilities.Utilities;
import com.buvanesh.task.viewmodel.NewsFeedViewModel;

public class NewsFeedActivity extends BaseActivity<ActivityNewsFeedBinding> implements NewsFeedView ,
        SwipeRefreshLayout.OnRefreshListener{

    public NewsFeedViewModel newsFeedViewModel;

    @Override
    public int getLayout() {
        return R.layout.activity_news_feed;
    }

    @Override
    public Activity getActivity() {
        return NewsFeedActivity.this;
    }

    @Override
    public void initializeViewModel() {
        newsFeedViewModel = ViewModelProviders.of(this).get(NewsFeedViewModel.class);
        newsFeedViewModel.callNewsFeedAPI(NewsFeedActivity.this,this);
        getViewBinding().swipeContainer.setOnRefreshListener(this);
    }

    @Override
    public void showHideView(boolean value) {
        getViewBinding().txtProgress.setVisibility(value? View.VISIBLE:View.GONE);
        getViewBinding().swipeContainer.setRefreshing(value);
    }

    @Override
    public void onNewsFeedSuccess(NewsFeedModel newsFeedModel) {
        if(!TextUtils.isEmpty(newsFeedModel.getTitle())) {
            getSupportActionBar().setTitle(newsFeedModel.getTitle());
        }
        RecyclerView recyclerNewsFeed = getViewBinding().recyclerNewsFeed;
        Utilities.setRecyclerViewAnimator(NewsFeedActivity.this,recyclerNewsFeed);
        NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(newsFeedModel.getRows());
        recyclerNewsFeed.setAdapter(newsFeedAdapter);
    }

    @Override
    public void statusMessage(String message) {
        TextView textError = getViewBinding().txtProgress;
        textError.setVisibility(View.VISIBLE);
        textError.setText(message);
    }

    @Override
    public void onRefresh() {
        newsFeedViewModel.callNewsFeedAPI(NewsFeedActivity.this,this);
    }
}
