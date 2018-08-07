package com.buvanesh.task.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.buvanesh.task.R;
import com.buvanesh.task.core.base.CustomBaseListener;
import com.buvanesh.task.core.service.RetrofitClient;
import com.buvanesh.task.core.service.ServiceCallBack;
import com.buvanesh.task.model.NewsFeedModel;
import com.buvanesh.task.utilities.Utilities;
import com.buvanesh.task.view.NewsFeedView;

import retrofit2.Response;

public class NewsFeedViewModel extends ViewModel implements ServiceCallBack{
    public NewsFeedView newsFeedView;

    @Override
    public void onSuccess(Response response) {
        NewsFeedModel newsFeedModel = (NewsFeedModel) response.body();
        newsFeedView.onNewsFeedSuccess(newsFeedModel);
        newsFeedView.showHideView(false);
    }

    @Override
    public void onFailure(String errorString) {
        newsFeedView.statusMessage(errorString);
        newsFeedView.showHideView(false);
    }

    /**
     * To make the API call to fetch News Feeds
     * @param context reference of the activity
     * @param view activity listener
     * */
    public void callNewsFeedAPI(Context context,NewsFeedView view){
        newsFeedView = view;
        if(Utilities.isConnected(context)){
            RetrofitClient.getInstance().getNewsFeed().
                    enqueue(new CustomBaseListener<NewsFeedModel>(this,context));
        }else{
            newsFeedView.showHideView(false);
            Utilities.showAlert(context,context.getResources().getString(R.string.check_network));
        }
    }
}
