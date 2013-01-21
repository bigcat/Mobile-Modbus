package com.bencatlin.mobilemodbus.ui;
/****************************************************************************
 * 
 * Class: MenuFragment
 * 
 * Description:
 *   This instantiates a menu object based on user preferences. For now, the
 *   only menu option will be the basic menu, which contains a simple 
 * 
 * 
 * 
 * 
 * 
 ****************************************************************************/

import com.bencatlin.mobilemodbus.interfaces.MenuProvider;

import android.content.Context;
import android.support.v4.app.Fragment;

public class MenuFragment extends Fragment {

	/*=========================================================================
	 * Public Members
	 *========================================================================*/
	
	
	/*=========================================================================
	 * Private Members
	 *========================================================================*/
	
	private MenuProvider mMenuProvider;
	private Context mContext;
	
	
	/*=========================================================================
	 * Public Methods
	 *========================================================================*/
	
	
	/**
	 * Constructor
	 * 
	 */
	
	public MenuFragment (Context c) {
		this.mContext = c;
	}
	
	
	/*=========================================================================
	 * Private Methods
	 *========================================================================*/
	
	
	
}
