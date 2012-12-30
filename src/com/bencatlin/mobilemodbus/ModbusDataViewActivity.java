package com.bencatlin.mobilemodbus;
/***********************************************************************
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
 ***********************************************************************/


import com.slidingmenu.lib.app.SlidingFragmentActivity;
import android.os.Bundle;
import android.view.Menu;


public class ModbusDataViewActivity extends SlidingFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modbusdataview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_modbusdataview, menu);
		return true;
	}

}
