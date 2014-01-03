package com.bencatlin.mobilemodbus.ui;
/******************************************************************************
 * ModbusDataViewActivity
 * 
 * This is the activity that starts the main application and views.
 * 
 * 
 * 
 * @author Ben Catlin
 * 
 * GPL 3.0 
 * TODO: Add GPL Preamble
 * 
 *****************************************************************************/

import android.app.Activity;
//import android.support.v7.app.ActionBar;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.view.GravityCompat;

import com.bencatlin.mobilemodbus.MMConstants;
import com.bencatlin.mobilemodbus.R;
import com.bencatlin.mobilemodbus.ui.fragments.BasicSlidingMenuFragment;

/**============================================================================
 * 
 * Class: ModbusDataActivity
 * 
 *
 *=============================================================================*/
public class ModbusDataViewActivity extends Activity {
	
	private String TAG = "MM/MainActivity";
	private static MMConstants mConstants = new MMConstants();

	private static final String PREF_FIRST_RUN = "first_run";
	
	//private Fragment mMenu;
	private Fragment mBatchProviderMenu; //This should also implement the menu and batch interface
	private ActionBar mActionBar;
    private DrawerLayout mMainDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
	private SharedPreferences mSettings;
	private Boolean mFirstRun = false;
	private int mVersionNumber = -1;
	private Handler mBatchResponseHandler;

    private CharSequence mDrawerTitle = "Connection Options";
    private CharSequence mTitle = "Mobile Modbus";
	
	/**
	 * 
	 * 
	 * 
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
        /* Get the current version from package */
        PackageInfo pinfo = null;
        try {
            pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (NameNotFoundException e) {
            Log.e(TAG, "package info not found.");
        }
        if (pinfo != null)
            mVersionNumber = pinfo.versionCode;
		
        /* Get settings */
        mSettings = PreferenceManager.getDefaultSharedPreferences(this);

        /* Check if it's the first run */
        mFirstRun = mSettings.getInt(PREF_FIRST_RUN, -1) != mVersionNumber;
        if (mFirstRun) {
             Editor editor = mSettings.edit();
             editor.putInt(PREF_FIRST_RUN, mVersionNumber);
             editor.commit();
        }
		
		super.onCreate(savedInstanceState);

        /***  Set up some data tracking for user metrics ***/


		/*** Start initializing the UI ***/
		
		// Set up the content
        setContentView( R.layout.activity_modbusdataview );
        mMainDrawerLayout = (DrawerLayout) findViewById(R.id.main_activity_drawer_layout);
        mMainDrawerLayout.setDrawerShadow( R.drawable.drawer_shadow, GravityCompat.START );

		
		this.buildMenu();


        /* Set up the handler for our batch responses */

        mBatchResponseHandler = getWindow().getDecorView().getHandler();


        /* Initialize UI variables */

        /* Set up the action bar */
        mActionBar = this.getActionBar();
        mActionBar.setDisplayHomeAsUpEnabled( true );
        mActionBar.setHomeButtonEnabled( true );
        mDrawerToggle.syncState();
        
		
	}

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }


    /**
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

	
	/**
	 * 
	 */
	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			mMenu.toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
	
	/**
	 * 
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_modbusdataview, menu);
	    return true;
	}

    /* Called whenever we call invalidateOptionsMenu() */

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
	
	
	/*-----------------------------------------------------------------------
	 * Private Methods
	 *-----------------------------------------------------------------------*/
	
	/*
	 * buildMenu
	 * 
	 * Builds the local menu with the correct parameters
	 * 
	 */
	private void buildMenu() {

        mTitle = getResources().getString( R.string.drawer_closed_title );
        mDrawerTitle = getResources().getString( R.string.drawer_open_title );

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mMainDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open_title,
                R.string.drawer_closed_title) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mMainDrawerLayout.setDrawerListener(mDrawerToggle);

		
	}
	
	
}
