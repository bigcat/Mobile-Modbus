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
 * 
 *****************************************************************************/

import com.bencatlin.mobilemodbus.MMConstants;
import com.bencatlin.mobilemodbus.R;
import com.bencatlin.mobilemodbus.R.id;
import com.bencatlin.mobilemodbus.R.layout;
import com.bencatlin.mobilemodbus.interfaces.MenuProvider;
import com.bencatlin.mobilemodbus.ui.fragments.BasicSlidingMenuFragment;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.ActionBar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**============================================================================
 * 
 * Class: ModbusDataActivity
 * 
 *
 */
public class ModbusDataViewActivity extends SlidingFragmentActivity {
	
	private String TAG = "MM/MainActivity";

	private static final String PREF_FIRST_RUN = "first_run";
	
	private SlidingMenu mMenu;
	private Fragment mMenuProvider; //This should also implement the menu and batch interface
	private ActionBar mActionBar;
	private SharedPreferences mSettings;
	private Boolean mFirstRun = false;
	private int mVersionNumber = -1;
	
	
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
		
		/*** Start initializing the UI ***/
		
		// Set up the content
		setContentView(R.layout.activity_modbusdataview);
		this.setBehindContentView(R.layout.menu_frame); //set up dummy placeholder
		
		// Set up the slide-in menu Fragment
		mMenuProvider = new BasicSlidingMenuFragment();  
		//This doesn't do crap because all the important stuff is done in onCreate() which is fired during the fragment placement/lifecycle
				
		FragmentTransaction t = getFragmentManager().beginTransaction();
		t.replace(R.id.menu_frame, mMenuProvider);
		t.commit();
		
		this.buildMenu();
		

        /* Initialize UI variables */
        /*mInfoLayout = v_main.findViewById(R.id.info_layout);
        mInfoProgress = (ProgressBar) v_main.findViewById(R.id.info_progress);
        mInfoText = (TextView) v_main.findViewById(R.id.info_text); */

        /* Set up the action bar */
        mActionBar = this.getActionBar();
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        //mActionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        /* Add padding between the home button and the arrow */
        ImageView home = (ImageView)findViewById(MMConstants.SUPPORTS_HONEYCOMB
                ? android.R.id.home : R.id.abs__home);
        if (home != null)
            home.setPadding(20, 0, 0, 0);
		
	}
	
	/**
	 * 
	 */
	@Override
	public void onBackPressed() {
		if (mMenu.isMenuShowing()) {
			mMenu.showContent();
		} else {
			super.onBackPressed();
		}
	}
	
	/**
	 * 
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			mMenu.toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_modbusdataview, menu);
	    return true;
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
		
		if (mMenu == null) {
			this.mMenu = this.getSlidingMenu();
			
			// build menu parameters
			mMenu.setMode(SlidingMenu.LEFT);
	        mMenu.setTouchModeAbove( SlidingMenu.TOUCHMODE_FULLSCREEN );
	        mMenu.setShadowWidthRes( R.dimen.shadow_width );
	        mMenu.setShadowDrawable( R.drawable.defaultshadow );
	        mMenu.setBehindOffsetRes( R.dimen.slidingmenu_offset );
	        mMenu.setFadeEnabled( true );
	        mMenu.setFadeDegree( 0.35f );

	        //mMenu.setMenu( this ); //TODO: This might not work!!!! Check 
		}
		
	}
	
	
}
