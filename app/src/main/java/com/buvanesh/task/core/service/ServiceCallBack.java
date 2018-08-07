package com.buvanesh.task.core.service;

import retrofit2.Response;

public interface ServiceCallBack<T> {

    /**
    * To get the success response
    * @param response represents the response body
    * */
    void onSuccess(Response<T> response);

    /**
    * To get the failure response
    * @param errorString represents the error message
    * */
    void onFailure(String errorString);
}