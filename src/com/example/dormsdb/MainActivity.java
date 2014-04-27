package com.example.dormsdb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
<<<<<<< HEAD
import android.graphics.Typeface;
=======
>>>>>>> 5ba1e2a8990808dbbc87fcd1cec40b5bc6bbb313
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
<<<<<<< HEAD
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
=======
import android.widget.TextView;
>>>>>>> 5ba1e2a8990808dbbc87fcd1cec40b5bc6bbb313

public class MainActivity extends Activity {
	
	private CheckBox checkBoxPrinter,checkBoxLaundry,checkBoxSubFree,checkBoxAC;
<<<<<<< HEAD
	private TextView mLogOut, mEmailDisplay, mRoomNum,room_text;
=======
	private TextView mLogOut, mEmailDisplay;
>>>>>>> 5ba1e2a8990808dbbc87fcd1cec40b5bc6bbb313
	public Button buttonSearch;
	public String printData = ""; 
	public String acData = "";
	public String campusData = "";
	public String subfreeData = "";
	public String laundryData = "";
<<<<<<< HEAD
	public String roomData = "";
	public String check;
	public Spinner spinner;
=======
	public String check;
>>>>>>> 5ba1e2a8990808dbbc87fcd1cec40b5bc6bbb313
	
	/*public static final String PREFS_NAME = "MyPrefsFile";
	private static final String PREF_USERNAME = "username";
	private static final String PREF_PASSWORD = "password";*/
	
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checker();
        setContentView(R.layout.activity_main);
        
<<<<<<< HEAD
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        
        mEmailDisplay = (TextView) findViewById(R.id.email_display);
        mLogOut = (TextView) findViewById(R.id.Logout);
        mRoomNum = (TextView) findViewById(R.id.roomNum);
        room_text = (TextView) findViewById(R.id.roomNum_text);
        
        
       
       room_text.setTypeface(tf);
       mRoomNum.setTypeface(tf);
    
        
        mEmailDisplay.setText(check);
        
       
        
        
        spinner = (Spinner) findViewById(R.id.campus_spinner);
     // Create an ArrayAdapter using the string array and a default spinner layout
     ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
             R.array.campus_name, R.layout.spinner_layout);
     // Specify the layout to use when the list of choices appears
     adapter.setDropDownViewResource(R.layout.spinner_layout_2);
     
     // Apply the adapter to the spinner
     spinner.setAdapter(adapter);
     
     
     spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	
		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
			
			Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
			TextView spinnerText = (TextView) findViewById(R.id.spinner_text);
		     spinnerText.setTypeface(tf);
		
		if (pos > 0){
			
    	 campusData = "&campus=" + spinner.getItemAtPosition(pos).toString();
		}
		
	
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		

	});
     
        
=======
        mEmailDisplay = (TextView) findViewById(R.id.email_display);
        mLogOut = (TextView) findViewById(R.id.Logout);
        
        mEmailDisplay.setText(check);
        
>>>>>>> 5ba1e2a8990808dbbc87fcd1cec40b5bc6bbb313
        mLogOut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mLogOut.setTextColor(Color.RED);
				SharedPreferences myPrefs = getSharedPreferences("PREFS", MODE_PRIVATE);
		    	Editor editor = myPrefs.edit();
		    	editor.clear();
		    	editor.apply();
		    	checker();
				
			}
		});
        
        
  
        setTitle("DORMSdb");
 
        
        addListenerOncheckBoxes();
        addListenerOnButton();
        
        
    }
    
<<<<<<< HEAD
=======

    
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	
    	
    }
 

>>>>>>> 5ba1e2a8990808dbbc87fcd1cec40b5bc6bbb313

    
 



	private void addListenerOncheckBoxes() {
		// TODO Auto-generated method stub
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
    	
    	checkBoxPrinter = (CheckBox) findViewById(R.id.checkBoxPrinter);
    	checkBoxLaundry = (CheckBox) findViewById(R.id.checkBoxLaundry);
    	checkBoxSubFree = (CheckBox) findViewById(R.id.SubFree);
    	checkBoxAC = (CheckBox) findViewById(R.id.checkBoxAC);
   	
    	checkBoxAC.setTypeface(tf);
    	checkBoxLaundry.setTypeface(tf);
    	checkBoxPrinter.setTypeface(tf);
    	checkBoxSubFree.setTypeface(tf);
    	checkBoxPrinter.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		
    		public void onClick (View v) {
    			
    			if (((CheckBox) v).isChecked()) {
    				printData = "&printer=1";}
    			else printData = "";
    			}
    		
    		
    	});
    	
    	checkBoxLaundry.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		
    		public void onClick (View v) {
    			
    			if (((CheckBox) v).isChecked()) {
    				laundryData = "&laundry=1";}
    			else laundryData = "";
    			}
    		
    		
    	});

    	checkBoxAC.setOnClickListener(new OnClickListener() {
	
	@Override
	
	public void onClick (View v) {
		
		if (((CheckBox) v).isChecked()) {
			acData = "&ac=1";}
		else acData = "";
		}
	
	
});
    	
    	checkBoxSubFree.setOnClickListener(new OnClickListener() {
    		@Override
    		
    		public void onClick (View v) {
    			
    			if (((CheckBox) v).isChecked()) {
    				subfreeData = "&subfree=1";}
    			else subfreeData = "";
    	
    		}
    		});
	}
	 
	 private void addListenerOnButton() {
			// TODO Auto-generated method stub
	    	
	    	checkBoxPrinter = (CheckBox) findViewById(R.id.checkBoxPrinter);
	    	checkBoxLaundry = (CheckBox) findViewById(R.id.checkBoxLaundry);
	    	checkBoxAC = (CheckBox) findViewById(R.id.checkBoxAC);
	    	checkBoxSubFree = (CheckBox) findViewById(R.id.SubFree);
	    	buttonSearch = (Button) findViewById(R.id.buttonSearch);
	    	
	    	buttonSearch.setOnClickListener(new OnClickListener() {
	    		
	    		@Override
	    		public void onClick (View v) {
	    			

	    			roomData = mRoomNum.getText().toString();
	    		    			 
	    			if (roomData.isEmpty()){
	    				
	    				roomData="";
	    				roomData = "&room=" + roomData;
	    		    	 
		    			Intent myIntent = new Intent(MainActivity.this, searchBox.class);
		    			myIntent.putExtra("LD", laundryData);
		    			myIntent.putExtra("AD", acData);
		    			myIntent.putExtra("PD", printData);
		    			myIntent.putExtra("SFD", subfreeData);
		    			myIntent.putExtra("CD", campusData);
		    			myIntent.putExtra("RD", roomData);
		    			MainActivity.this.startActivity(myIntent);
	    				
	    				
	    			}
	    			
	    			else if (roomData.length() != 4){
	    		    		 
	    		    		 AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
	    						builder.setMessage("Please enter a valid room number")
	    							.setTitle("error")
	    							.setPositiveButton(android.R.string.ok,null);
	    						
	    						AlertDialog dialog = builder.create();
	    						dialog.show();
	    						
	    		    		 
	    		    	 }  
	    			
	    			else {
	    			
	    			
	    		    		 
	    		    	 
	    		    roomData = "&room=" + roomData;
	    		    	 
	    			Intent myIntent = new Intent(MainActivity.this, searchBox.class);
	    			myIntent.putExtra("LD", laundryData);
	    			myIntent.putExtra("AD", acData);
	    			myIntent.putExtra("PD", printData);
	    			myIntent.putExtra("SFD", subfreeData);
	    			myIntent.putExtra("CD", campusData);
	    			myIntent.putExtra("RD", roomData);
	    			MainActivity.this.startActivity(myIntent);
	    		
	    			}
	    		    	 
	    		}
	    	});
	    	
	    	
			
		}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	private boolean checker(){
    	
	    SharedPreferences myPrefs = getSharedPreferences("PREFS", 0);
	    
	    check = myPrefs.getString("Login", "none");
	    
	    //Toast.makeText(this, "you are" + check, Toast.LENGTH_LONG).show();
	    
	    if (check.equals("none")) {
	    	
	    	Intent intent = new Intent(MainActivity.this, LoginActivity.class);
	    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
	    	startActivity(intent);
	    }
		return false;
	    
    
    }
    
}
