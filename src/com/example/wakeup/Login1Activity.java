package com.example.wakeup;

import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login1Activity extends ActionBarActivity {
	
	String[] value;
	SharedPreferences sharedPref ;
	public static String PREFS_NAME = "MyPrefsFile";
	
	//public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login1);
		
		EditText User = (EditText) findViewById(R.id.userName);
		final EditText password = (EditText) findViewById(R.id.password);
		
		sharedPref =this.getSharedPreferences(getString(R.string.sharedPref), Context.MODE_PRIVATE);
		String user = sharedPref.getString("userName", "");
		String pass = sharedPref.getString("password", "");

		//if(user!="" && pass!=""){
			User.setText(user);
			password.setText(pass);		
		//}

		//else{		
		
		value = new String[2];
		
		
		password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
		
	
	    
		value[1] = User.getText().toString();
		value[0] = password.getText().toString();
		
		
		Button loginBtn = (Button) findViewById(R.id.button_login);
		
		loginBtn.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(Login1Activity.this, DisplayMessageActivity.class);
			    
			    //.putExtra("user", value[0]);
			    //intent.putExtra("password", value[1]);
				 
				 SharedPreferences.Editor editor = sharedPref.edit();
				 editor.putString("userName", value[0]);
				 editor.putString("password", value[1]);
				 editor.commit();
				
			    startActivity(intent);
			}
		});
		//}
	    
	    //TODO gereftane etelaat
	
	    

	}
/*	public void sendMessage(View view) {
		
	}*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
