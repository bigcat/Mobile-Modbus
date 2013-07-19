/*
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bencatlin.mobilemodbus.util;

import android.content.Context;

import com.bencatlin.mobilemodbus.MMConstants;
import com.bencatlin.mobilemodbus.util.base.IStrictMode;
import com.bencatlin.mobilemodbus.util.base.SharedPreferenceSaver;

/**
 * Factory class to create the correct instances
 * of a variety of classes with platform specific
 * implementations.
 * 
 */
public class PlatformSpecificImplementationFactory {    

  
  /**
   * Create a new StrictMode instance.
   * @return StrictMode
   */
  public static IStrictMode getStrictMode() {
	if (MMConstants.SUPPORTS_HONEYCOMB)
      return new HoneycombStrictMode();
	else if (MMConstants.SUPPORTS_GINGERBREAD)
      return new LegacyStrictMode(); 
	else
      return null;
  }
  
  
  /**
   * Create a new SharedPreferenceSaver
   * @param context Context
   * @return SharedPreferenceSaver
   */
  public static SharedPreferenceSaver getSharedPreferenceSaver(Context context) {
    return  MMConstants.SUPPORTS_GINGERBREAD ? 
       new GingerbreadSharedPreferenceSaver(context) : 
       MMConstants.SUPPORTS_FROYO ? 
           new FroyoSharedPreferenceSaver(context) :
           new LegacySharedPreferenceSaver(context);
  }
}
