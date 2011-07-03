package com.marakana.yamba;

import winterwell.jtwitter.Twitter;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.util.Log;

public class YambaApplication extends Application implements OnSharedPreferenceChangeListener {

	private static final String TAG = YambaApplication.class.getSimpleName();
	private SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
	public Twitter t;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		prefs.registerOnSharedPreferenceChangeListener(this);
		Log.v(TAG,"Yamba application created");
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		Log.d(TAG, "Yamba Application terminated");
	}

	public synchronized Twitter getTwitter()
	{
		if (t==null)
		{
			String username,password,apiRoot;
			username = prefs.getString("username", "");
			password = prefs.getString("password", "");
			apiRoot  = prefs.getString("apiRoot","http://yamba.marakana.com/api");
			t = new Twitter(username,password);
			t.setAPIRootUrl(apiRoot);
		}
		return t;
	}
	@Override
	public synchronized void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub
		t = null;
	}

}
