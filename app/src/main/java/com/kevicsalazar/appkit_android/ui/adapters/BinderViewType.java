package com.kevicsalazar.appkit_android.ui.adapters;

import jp.satorufujiwara.binder.ViewType;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public enum BinderViewType implements ViewType {

    PARAGRAPH;

    @Override
    public int viewType() {
        return ordinal();
    }

}
