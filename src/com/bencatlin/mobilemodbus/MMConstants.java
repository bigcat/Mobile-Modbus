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

package com.bencatlin.mobilemodbus;

public class MMConstants {
  
  /**
   * You'll need to modify these values to suit your own app.
   */
  // TODO Turn off when deploying your app.
  public static boolean DEVELOPER_MODE = true;

  /**
   * These values are constants used for intents, extras, and shared preferences.
   * You shouldn't need to modify them.
   */
  public static String SHARED_PREFERENCE_FILE = "SHARED_PREFERENCE_FILE";
  public static String SP_KEY_RUN_ONCE = "SP_KEY_RUN_ONCE";
  
  public static boolean SUPPORTS_JELLYBEAN = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN;
  public static boolean SUPPORTS_ICECRAMSANDWICH = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
  public static boolean SUPPORTS_GINGERBREAD = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD;
  public static boolean SUPPORTS_HONEYCOMB = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB;
  public static boolean SUPPORTS_FROYO = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.FROYO;
  public static boolean SUPPORTS_ECLAIR = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ECLAIR;
  
}
