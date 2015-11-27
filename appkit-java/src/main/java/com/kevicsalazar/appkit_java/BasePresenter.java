package com.kevicsalazar.appkit_java;

/**
 * Created by Kevin Salazar
 */
public interface BasePresenter {

    /**
     * This method will be executed on
     * [AppCompatActivity.onStart] in case presenter is attached to activity
     * [Fragment.onStart]  in case presenter is attached to fragment
     */
    void onStart();

    /**
     * This method will be executed on
     * [AppCompatActivity.onStop] in case presenter is attached to activity
     * [Fragment.onStop]  in case presenter is attached to fragment
     */
    void onStop();

}
