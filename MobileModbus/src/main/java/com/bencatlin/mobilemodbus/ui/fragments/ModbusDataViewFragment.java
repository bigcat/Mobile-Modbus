package com.bencatlin.mobilemodbus.ui.fragments;
/******************************************************************************
 * ModbusDataViewFragment
 * 
 * Fragment used to display the data returned from the modbus batch.
 * 
 * For a tablet this shows a gridview with a varying number of columns 
 * depending on screen width, and for a phone a listview.
 * 
 * 
 * 
 * @author ben@bencatlin.com
 *****************************************************************************/

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.bencatlin.mobilemodbus.R;

public class ModbusDataViewFragment extends Fragment {

	// This will hold our view - it is an AbsListView because that is a
	//  common ancestor to both ListView and GridView - we will do
	//  type-specific work in the buildViewDetails method
	private AbsListView mDataView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		mDataView = (AbsListView) inflater.inflate(R.layout.modbus_data_fragment, container, false);
		
		return mDataView;
	}
	
	private void buildViewDetails () {
		
	}
	
	
	
}
