package com.bencatlin.mobilemodbus.interfaces;

import com.slidingmenu.lib.SlidingMenu;

public interface MenuProvider extends ModbusBatchProvider {
	
	public SlidingMenu getMenu();

}
