package com.c0dege3k.consolefm;

import android.*;
import android.R;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

/**
 * User: c0dege3k
 * Date: 3/11/13
 * Time: 12:14 AM
 * Package: com.c0dege3k.consolefm
 */
public class ListLoader extends ListActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {

    final static String TAG = "ListLoader";

    //Adapter used to display data
    SimpleCursorAdapter mAdapter;

    //Genre rows to retrieve- TODO: eventually edit to use Console API
    String[] genreData = {"Top", "Chill Out", "Dubstep", "Mashups", "Minimal", "etc"};
    //Song rows to retrieve- TODO: eventually edit to use Console API
    String[] songData = {"Song 1", "Song 2", "Song 3", "Song 4"};
    //Boolean to change between song and genre lists
    boolean loadSongs = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create a progress bar to display while loading
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        progressBar.setIndeterminate(true);
        getListView().setEmptyView(progressBar);

        //Adding progress bar to layout
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);

        //Views to load into list
        int[] toViews = {R.id.text1};

        //Create an adapter to display loaded data
        mAdapter = new SimpleCursorAdapter(this, R.layout.simple_list_item_1, null,
                (loadSongs ? songData:genreData), toViews, 0);
        setListAdapter(mAdapter);

        //Prepare new loader. Reconnect with old one or start new one.
        getLoaderManager().initLoader(0, null, this);
    }

    //Change between genre and song lists
    public void isSongList(boolean songOrGenre) {
        loadSongs = songOrGenre;
    }

    //Called when creating new Loader
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        //Creating CursorLoader that creates the Cursor for the data to be displayed
        //TODO Make this CL a fully defined one (other constructor) & differentiate between GENRE and SONG
        CursorLoader cursorLoader = new CursorLoader(this);
        cursorLoader.setProjection(loadSongs ? songData:genreData);
        Log.d(TAG, "Loading new cursor with " + (loadSongs ? songData : genreData));
        return cursorLoader;
    }
    //Called when previous loader finishes
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor data) {
        //Swap in new cursor. Let the framework do its thing
        mAdapter.swapCursor(data);
    }

    //Called when previous loader resets, making data unavailable
    public void onLoaderReset(Loader<Cursor> loader) {
        //Called when Finished cursor is being closed. Makes sure it is no longer being used.
        mAdapter.swapCursor(null);
    }

}
