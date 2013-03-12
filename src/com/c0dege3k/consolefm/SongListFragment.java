package com.c0dege3k.consolefm;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with IntelliJ IDEA.
 * User: c0dege3k
 * Date: 3/9/13
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class SongListFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.song_listing, container, false);
    }


}
