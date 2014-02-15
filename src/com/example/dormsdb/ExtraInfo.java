package com.example.dormsdb;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;


public class ExtraInfo extends MainActivity{
	
	private String hall;
	private String room;
	private String type ;
	private Float rating;
	private String raters;
	private String cluster;
	private String subfree;
	
	private TextView hall1;
	private TextView raters1;
	private TextView room1;
	private TextView subfree1;
	private TextView cluster1;
	private TextView type1;
	private RatingBar rating1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.extra_info2);
		
		hall = getIntent().getStringExtra("hall");		
		room = getIntent().getStringExtra("room");
		subfree = subFreeChecker(getIntent().getStringExtra("subfree"));
		type = typeChecker(getIntent().getStringExtra("type"));
		rating= Float.parseFloat(getIntent().getStringExtra("rating"));
		raters = getIntent().getStringExtra("raters");
		cluster = getIntent().getStringExtra("cluster");
	
	
	
hall1 = (TextView) findViewById(R.id.Hall);
subfree1 = (TextView) findViewById(R.id.SubfreeExtra);
raters1 = (TextView) findViewById(R.id.Raters);
room1 = (TextView) findViewById(R.id.Room);
cluster1 = (TextView) findViewById(R.id.Cluster);
type1 = (TextView) findViewById(R.id.Type);
rating1 = (RatingBar) findViewById(R.id.rating);



type1.setText("Type: " + type);
subfree1.setText(subfree);
hall1.setText(hall);
raters1.setText("Number of raters: " + raters);
room1.setText(room);
cluster1.setText("Cluster: " + cluster);
rating1.setRating(rating);

			

}
	
	
	private String subFreeChecker(String subfree) {
		if (subfree.equals("0")){
			subfree = "";
		} else subfree = "Substance Free";
		return subfree;
		
	}

	private String typeChecker(String type) {
		if (type.equals("D")) {
			type = "Double";	
		} else if (type.equals("S")) {
			type = "Single";
		} else if (type.equals("SC")) {
			type = "Cubby Single";
		} else if (type.equals("D2")){
			type = "Two-Room";
		} else if (type.equals("D3")) {
			type = "Three-Room";
		} else if (type.equals("T")) {
			type = "Triple";
		} else if (type.equals("T2")) {
			type = "Two-Room Triple";
		} else if (type.equals("Q")) {
			type = "Quad";
		} else if (type.equals("AS")){
			type = "Student Advisor";
		} else if (type.equals("HWC")){
			type = "Hall Wellness Coordinator";
		} else if (type.equals("APART")){
			type = "Apartment Living";
		} else if (type.equals("COOP")) {
			type = "Co-op";
		} else if (type.equals("")){
			type = "Unknown";
		}
		return type;
	}
	
}
	

