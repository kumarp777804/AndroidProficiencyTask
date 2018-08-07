package com.buvanesh.task.core.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.buvanesh.task.core.service.ServiceCallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomBaseListener <T> implements Callback<T> {

    final Context context;
    final ServiceCallBack serviceListener;

    /**
     * @param serviceListener service response listener
     * @param context context of current activity or fragment
     * */
    public CustomBaseListener(ServiceCallBack serviceListener, Context context) {
        this.serviceListener = serviceListener;
        this.context = context;
    }


    @Override
    public void onResponse(@NonNull Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            if (serviceListener != null) {
                serviceListener.onSuccess(response);
            }

        } else {
            if (serviceListener != null)
                serviceListener.onFailure(response.message());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        serviceListener.onFailure(t.getMessage());
    }
}
