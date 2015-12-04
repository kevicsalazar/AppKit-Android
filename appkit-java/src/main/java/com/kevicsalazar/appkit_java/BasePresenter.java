package com.kevicsalazar.appkit_java;

/**
 * Created by Kevin Salazar
 */
public abstract class BasePresenter<T> {

    protected T view;

    public BasePresenter with(T v) {
        view = v;
        return this;
    }

    /**
     * This method will be executed on
     * [AppCompatActivity.onStart] in case presenter is attached to activity
     * [Fragment.onStart]  in case presenter is attached to fragment
     */
    public abstract void onStart();

    /**
     * This method will be executed on
     * [AppCompatActivity.onStop] in case presenter is attached to activity
     * [Fragment.onStop]  in case presenter is attached to fragment
     */
    public abstract void onStop();

}
