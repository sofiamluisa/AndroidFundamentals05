package com.android.androidfundamentalsgroup1;

import android.util.Log;

public class Logging {
  public static void show(Object obj, String message) {
      // log details only in debug mode
      // BuildConfig.DEBUG is one-to-one with debug flavor from build.gradle (Module: app)
      if (BuildConfig.DEBUG) {
          Log.e(obj.getClass().getName(), message);
      }
  }

    public static void show(String obj, String message) {
        // log details only in debug mode
        // BuildConfig.DEBUG is one-to-one with debug flavor from build.gradle (Module: app)
        if (BuildConfig.DEBUG) {
            Log.e(obj, message);
        }
    }
}
