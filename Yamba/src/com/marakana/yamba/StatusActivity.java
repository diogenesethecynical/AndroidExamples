package com.marakana.yamba;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Color;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StatusActivity extends Activity implements OnClickListener, TextWatcher


{
	private final String TAG = "Status Activity";
	Button updateButton;
	EditText editText;
	
	TextView textCount;
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        
        Log.v(TAG,"Starting Status Activity");
        
        updateButton = (Button)findViewById(R.id.buttonUpdate);
        editText     = (EditText)findViewById(R.id.editText); 
        textCount    = (TextView)findViewById(R.id.textCount);
    
        
		textCount.setTextColor(Color.GREEN);
		textCount.setText(Integer.toString(140-editText.length()));
		
      
        
        updateButton.setOnClickListener(this);
        editText.addTextChangedListener(this);
    
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d(TAG,"OnClick entering");
		try{
			String status = editText.getText().toString();
//			getTwitter().setStatus(status);		
		}
		catch(TwitterException e)
		{
			Log.d(TAG, "Twitter setStatus failed: " + e);
		}
		Log.d(TAG,"OnClick leaving");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId())
		{
			case R.id.itemPrefs:
			Intent i = new Intent(StatusActivity.this,PrefsActivity.class);
			startActivity(i);
			break;
			
			case R.id.itemServiceStart:
				startService(new Intent(this,UpdaterService.class));
				break;
				
			case R.id.itemServiceStop:
				stopService(new Intent(this,UpdaterService.class));
				break;
		}
		
		return true;
	}



	class PostToTwitter extends AsyncTask<String, Integer, String>
	{

		@Override
		protected String doInBackground(String... statuses) {
			// TODO Auto-generated method stub
			try {
				YambaApplication yamba = ((YambaApplication)getApplication());
				
		        Twitter.Status status = yamba.getTwitter().updateStatus(statuses[0]);
		        return status.text;
		      } catch (TwitterException e) {
		        Log.e(TAG, e.toString());
		      
		        return "Failed to post";
		      }
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			Toast.makeText(StatusActivity.this, result, Toast.LENGTH_LONG).show();
			
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
		
		
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		int remainingChars = 140 - editText.length();
			if  (remainingChars> 10)
			{
				
				textCount.setTextColor(Color.GREEN);
			}
			else if (remainingChars < 10 && remainingChars > 0)
			{
				textCount.setTextColor(Color.YELLOW);
			}
			else
			{
				textCount.setTextColor(Color.RED);
				textCount.setBackgroundColor(Color.WHITE);
			}
				
			textCount.setText(Integer.toString(remainingChars));
	}
	
	
	
	
}
