package com.example.wakeup;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class DisplayMessageActivity extends ActionBarActivity {
	
	SharedPreferences sharedPref ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		
		sharedPref =this.getSharedPreferences(getString(R.string.sharedPref), Context.MODE_PRIVATE);
		String user = sharedPref.getString("userName", "");
		String pass = sharedPref.getString("password", "");
		
		EditText User = (EditText) findViewById(R.id.User);
		EditText Pass = (EditText) findViewById(R.id.Pass);
		
		User.setText("username : "+user);
		Pass.setText("Pass : "+pass);
		
	}

	public void getInformations(View view){
		
	   // EditText  phoneNumber = (EditText) findViewById(R.id.PhoneNumber);

	}
	

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
