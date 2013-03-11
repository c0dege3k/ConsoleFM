package com.c0dege3k.consolefm;

import android.app.ActionBar;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created with IntelliJ IDEA.
 * User: c0dege3k
 * Date: 3/5/13
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class RootView extends FrameLayout {

    View sideMenu;
    ActionBar actionBar;

    public RootView(Context context) {
        super(context);
    }

    public void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
