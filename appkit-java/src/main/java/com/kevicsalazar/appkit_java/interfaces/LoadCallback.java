package com.kevicsalazar.appkit_java.interfaces;

import com.kevicsalazar.appkit_java.enums.LoadStatus;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public interface LoadCallback<L> {

    /**
     * Called when load status changes
     *
     * @param status can be
     *               {@link LoadStatus#LOADED}
     *               {@link LoadStatus#LOADING}
     */
    void onLoadStatus(LoadStatus status);

    /**
     * Called when load finished successfully
     *
     * @param l the generic type defined in angle brackets
     */
    void onLoadSuccess(L l);

    /**
     * Called when load finished unsuccessfully
     *
     * @param resId the string resId for message
     */
    void onLoadFailure(int resId);

}
