package com.example.wakeup;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class DisplayMessageActivity extends ActionBarActivity {
	
	SharedPreferences sharedPref ;
	Calendar calendar;
	Button dateB;
	static final int DATE_DIALOG_ID = 999;
	int day,
		month, 
		year; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		/*
		sharedPref =getSharedPreferences(getString(R.string.sharedPref), Context.MODE_PRIVATE);
		String user = sharedPref.getString("userName", "");
		String pass = sharedPref.getString("password", "");
		
		EditText User = (EditText) findViewById(R.id.User);
		EditText Pass = (EditText) findViewById(R.id.Pass);
		
		User.setText("username : "+user);
		Pass.setText("Pass : "+pass);
		*/
		setCalendar();
		setDate();
		addListenerOnButton();
		
		
	}
	
	/**
	 * set option of date Button
	 */
	public void setCalendar(){
		
		calendar =  Calendar.getInstance();
		
	}

	/**
	 * set option of date Button
	 */
	public void setDate(){
		
		dateB = (Button) findViewById(R.id.date);

		 day = calendar.get(Calendar.DAY_OF_MONTH);
		 month = calendar.get(Calendar.MONTH)+1;
		 year = calendar.get(Calendar.YEAR);
		
		dateB.setText(" "+String.valueOf(day)+" - "
				+String.valueOf(month)+" - "
				+String.valueOf(year)+" ");
		
	}
	
	/**
	 * this method show calendar in another page
	 */
	
	public void addListenerOnButton() {
		  
		dateB.setOnClickListener(new OnClickListener() {
 
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
 
				DisplayMessageActivity.this.showDialog(DATE_DIALOG_ID);
 
			}
 
		});
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set time picker as current time
			return new DatePickerDialog(this, datePickerListener,year, month,day);
 
		}
		return null;
	}
 
	private DatePickerDialog.OnDateSetListener datePickerListener = 
            new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {

			year = arg1;
			month = arg2+1;
			day = arg3;
 
			// set current time into text Button
			dateB.setText(" "+String.valueOf(day)+" - "
					+String.valueOf(month)+" - "
					+String.valueOf(year)+" ");

		}
	};
 
	private static String pad(int c) {
		if (c >= 10)
		   return String.valueOf(c);
		else
		   return "0" + String.valueOf(c);
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
