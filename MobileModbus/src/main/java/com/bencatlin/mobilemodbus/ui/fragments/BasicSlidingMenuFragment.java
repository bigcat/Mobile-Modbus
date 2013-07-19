package com.bencatlin.mobilemodbus.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bencatlin.mobilemodbus.R;
import com.bencatlin.mobilemodbus.interfaces.ModbusBatchProvider;
import com.serotonin.modbus4j.BatchRead;


/**
 * Class: BasicSlidingMenuFragment
 * 
 * TODO: Check for alternative way to implement a PreferenceFragment in API < v11
 * or replace with a ListFragment
 */
public class BasicSlidingMenuFragment extends PreferenceFragment 
										implements ModbusBatchProvider {

	private Context mContext;
	
	/* onCreate
	 * 
	 * (non-Javadoc)
	 * @see android.preference.PreferenceFragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Load the preferences from an XML resource
		this.addPreferencesFromResource(R.xml.preferences_basic_menu);

	}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = super.onCreateView(inflater, container, savedInstanceState);
        view.setBackgroundColor(getResources().getColor(android.R.color.white));

        return view;
    }
	
	
	/*
	 * onActivityCreated
	 * 
	 * This is where we instantiate things that require an activity context
	 * 
	 * (non-Javadoc)
	 * @see android.preference.PreferenceFragment#onActivityCreated(android.os.Bundle)
	 */
	/*@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		this.mContext = this.getActivity();
	}*/
	

	/*
	 * (non-Javadoc)
	 * @see com.bencatlin.mobilemodbus.interfaces.ModbusBatchProvider#getBatch()
	 */
	@Override
	public BatchRead getBatch() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
