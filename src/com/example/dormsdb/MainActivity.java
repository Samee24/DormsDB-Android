package com.example.dormsdb;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private CheckBox checkBoxPrinter,checkBoxLaundry,checkBoxSubFree,checkBoxAC;
	private TextView mLogOut, mEmailDisplay;
	public Button buttonSearch;
	public String printData = ""; 
	public String acData = "";
	public String subfreeData = "";
	public String laundryData = "";
	public String check;
	
	/*public static final String PREFS_NAME = "MyPrefsFile";
	private static final String PREF_USERNAME = "username";
	private static final String PREF_PASSWORD = "password";*/
	
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checker();
        setContentView(R.layout.activity_main);
        
        mEmailDisplay = (TextView) findViewById(R.id.email_display);
        mLogOut = (TextView) findViewById(R.id.Logout);
        
        mEmailDisplay.setText(check);
        
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
    

    
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	
    	
    }
 





	private void addListenerOncheckBoxes() {
		// TODO Auto-generated method stub
    	
    	
    	checkBoxPrinter = (CheckBox) findViewById(R.id.checkBoxPrinter);
    	checkBoxLaundry = (CheckBox) findViewById(R.id.checkBoxLaundry);
    	checkBoxSubFree = (CheckBox) findViewById(R.id.SubFree);
    	checkBoxAC = (CheckBox) findViewById(R.id.checkBoxAC);
   	

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
	    			
	    			Intent myIntent = new Intent(MainActivity.this, searchBox.class);
	    			myIntent.putExtra("LD", laundryData);
	    			myIntent.putExtra("AD", acData);
	    			myIntent.putExtra("PD", printData);
	    			myIntent.putExtra("SFD", subfreeData);
	    			MainActivity.this.startActivity(myIntent);
	    		
	    			
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
