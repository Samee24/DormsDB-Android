package com.example.dormsdb;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class customadapter extends BaseAdapter {
	 
    private ArrayList<MessageDetails> _data;
    Context _c;
    
    customadapter (ArrayList<MessageDetails> data, Context c){
        _data = data;
        _c = c;
    }
   
    public int getCount() {
        // TODO Auto-generated method stub
        return _data.size();
    }
    
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return _data.get(position);
    }
 
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
   
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
         View v = convertView;
         if (v == null)
         {
            LayoutInflater vi = (LayoutInflater)_c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.single_list_view, null);
         }
 
           TextView hallView = (TextView)v.findViewById(R.id.Hall);
           TextView roomView = (TextView)v.findViewById(R.id.Room);
           TextView clusterView = (TextView)v.findViewById(R.id.Cluster);
 
           MessageDetails msg = _data.get(position);
           hallView.setText(msg.hall);
           roomView.setText(msg.room);
           clusterView.setText(msg.cluster);                          
                        
        return v;
}
}
