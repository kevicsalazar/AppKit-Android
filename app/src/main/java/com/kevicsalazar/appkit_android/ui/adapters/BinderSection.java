package com.kevicsalazar.appkit_android.ui.adapters;

import jp.satorufujiwara.binder.Section;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public enum BinderSection implements Section {

    INTRODUCTION,
    PORTFOLIO;

    @Override
    public int position() {
        return ordinal();
    }
    
}
