package com.example.ankit;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	MediaPlayer mp;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		
		mp.stop();
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		
		mp = MediaPlayer.create(this, R.raw.braincandy);
		mp.setLooping(false);
	}


	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		
		mp.start();
	}



}
