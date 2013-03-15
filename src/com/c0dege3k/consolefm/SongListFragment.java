package com.c0dege3k.consolefm;

import android.*;
import android.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: c0dege3k
 * Date: 3/9/13
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class SongListFragment extends ListFragment{
    final static String TAG = "SongListFragment";

    final static String GENRE = "genre";
    final static String TOP_SONGS = "top";

    String[] songData = {"Song 1", "Song 2", "Song 3", "Song 4"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Setting ListAdapter with songData");
        //Creating adapter for the list. This is 10x easier than what I was trying to do with the ListLoader. derp.
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_activated_1, songData));
    }

    public void onStart() {
        super.onStart();
        //Checking to see what genre was passed to the song fragment
        Bundle args = getArguments();
        if (args != null) {
            //Set the list of songs based on the genre chosen
            setSongList(args.getString(GENRE));
        }
        else {
            setSongList(TOP_SONGS);
        }
    }

    public void setSongList(String genreName) {
        //Use Console API to get song list
    }

    public String toString() {
        //TODO TOP PRIORITY: WHY IS NPE HAPPENING HERE??????
        return "Song list is " + getListAdapter().getCount() + " songs long";
    }


}
