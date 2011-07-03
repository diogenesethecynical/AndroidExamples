package com.example.ankit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceDemo extends Activity implements OnClickListener {
	Button bStartService, bStopService;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bStartService = (Button)findViewById(R.id.startService);
        bStopService = (Button)findViewById(R.id.stopService);
        
        bStartService.setOnClickListener(this);
        bStopService.setOnClickListener(this);
        
        
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.startService:
			startService(new Intent(this,MyService.class));
			break;
			
		case R.id.stopService:
			stopService(new Intent(this,MyService.class));
			break;
		}
		
	}
}