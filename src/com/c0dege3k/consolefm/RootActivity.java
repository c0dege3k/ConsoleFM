package com.c0dege3k.consolefm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class RootActivity extends Activity {

    final static String TAG = "RootActivity";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Check if activity is using SongListFragment
        if (findViewById(R.id.fragment_container) != null) {
            Log.d(TAG, "fragment_container exists");

            //Return if there's already a saved state- don't create overlapping frags
            if (savedInstanceState != null) {
                Log.d(TAG, "savedinstancestate exists, exiting onCreate");
                return;
            }

            //Create instance of SongListFrag
            SongListFragment songFrag = new SongListFragment();
            Log.d(TAG, "songFrag = "+songFrag.toString());

            //Get genre stream list to pull from to load SongFrag

            getFragmentManager().beginTransaction().add(R.id.fragment_container, songFrag);
        }
    }
}
