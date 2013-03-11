package com.c0dege3k.consolefm;

import android.app.Activity;
import android.os.Bundle;

public class RootActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Check if activity is using SongListFragment
        if (findViewById(R.id.fragment_container) != null) {

            //Return if there's already a saved state- don't create overlapping frags
            if (savedInstanceState != null) {
                return;
            }

            //Create instance of SongListFrag
            SongListFragment songFrag = new SongListFragment();

            //Get genre stream list to pull from to load Frag

        }
    }
}
