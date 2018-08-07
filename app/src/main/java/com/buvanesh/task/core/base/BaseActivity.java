package com.buvanesh.task.core.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity{

    /*
    * To get the layout of the child activity
    * */
    public abstract int getLayout();

    /*
    * To get the current activity
    * */
    public abstract Activity getActivity();

    /*
    * To initialize the view model
    * */
    public abstract void initializeViewModel();

    public T dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initializing the data binder view with activity
        dataBinding = DataBindingUtil.setContentView(getActivity(),getLayout());
        initializeViewModel();
    }

    /*
    * To return the data binder view
    * */
    public T getViewBinding(){
        return dataBinding;
    }
}
