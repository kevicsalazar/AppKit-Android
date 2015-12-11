package com.kevicsalazar.appkit_java.interfaces;

import com.kevicsalazar.appkit_java.enums.LoadStatus;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public interface SimpleCallback {

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
     */
    void onLoadSuccess();

    /**
     * Called when load finished unsuccessfully
     *
     * @param resId the string resId for message
     */
    void onLoadFailure(int resId);

}
