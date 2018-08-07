package com.buvanesh.task.view;

import com.buvanesh.task.model.NewsFeedModel;

public interface NewsFeedView {

    /**
     * To show and Hide the view
     * @param value represents the bool value to show or hide the view
     * */
    void showHideView(boolean value);

    /**
     * To get the response body after success response
     * @param newsFeedModel success response body
     * */
    void onNewsFeedSuccess(NewsFeedModel newsFeedModel);

    /**
     * To get the error message to show
     * @param message error or progress message
     * */
    void statusMessage(String message);
}
