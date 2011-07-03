package com.example.ankit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.setAction("com.example.ankit.MyService");
		context.startService(i);
		
	}

}
