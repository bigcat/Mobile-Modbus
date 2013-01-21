package com.bencatlin.mobilemodbus.ui;

import android.content.Context;

import com.bencatlin.mobilemodbus.interfaces.MenuProvider;
import com.slidingmenu.lib.SlidingMenu;

public class BasicSlidingMenuProvider implements MenuProvider {

	private Context mContext;
	
	public BasicSlidingMenuProvider(Context c) {
		mContext = c;
	}
	
	@Override
	public SlidingMenu getMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
