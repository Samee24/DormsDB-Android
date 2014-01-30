package com.example.dormsdb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity {
	
	private CheckBox checkBoxPrinter,checkBoxLaundry,checkBoxSubFree,checkBoxAC;
	public Button buttonSearch;
	public String printData = "";
	public String acData = "";
	public String subfreeData = "";
	public String laundryData = "";
	
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addListenerOncheckBoxes();
        addListenerOnButton();
        
        
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
    
}
