package com.ankit.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NDK extends Activity {
	
	NDK nativeLib;
	EditText one,two,three;
	
	static {
	    System.loadLibrary("ndk_demo");
	  }
	
	 /** 
	   * Adds two integers, returning their sum
	   */
	  public native int add( int v1, int v2 );
	  
	  /**
	   * Returns Hello World string
	   */
	  public native String hello();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        nativeLib = new NDK();
        String s = nativeLib.hello();
        TextView tv = (TextView)findViewById(R.id.textView1);
         one = (EditText)findViewById(R.id.editText1);
         two = (EditText)findViewById(R.id.editText2);
         three = (EditText)findViewById(R.id.editText3);
        tv.setText(s);
        
        Button b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 int v1, v2, res = -1;
			        v1 = Integer.parseInt(one.getText().toString());
			        v2 = Integer.parseInt(two.getText().toString());

			        res = nativeLib.add(v1, v2);
			        three.setText(new Integer(res).toString());
				
			}
		});
    }
}