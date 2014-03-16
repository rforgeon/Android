package com.example.resturantrater;

import java.util.ArrayList;

import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import android.widget.BaseAdapter;


public class MainResturantList extends ListActivity {

	DataStore myData = DataStore.getInstance();
	ArrayList<Resturant> resturants = myData.getResturantList();
	ArrayList<String> items = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_resturant_list);
		
		
		
		
		//Start Parser
		      
				
		try {
			XmlPullParser xpp = getResources().getXml(R.xml.data);

			while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
				if (xpp.getEventType() == XmlPullParser.START_TAG) {
					
					if (xpp.getName().equals("name")) {
						items.add(xpp.getAttributeValue(0));
					}
					if (xpp.getName().equals("phone")) {
						items.add(xpp.getAttributeValue(0));
					}
					if (xpp.getName().equals("website")) {
						items.add(xpp.getAttributeValue(0));
					}
					if (xpp.getName().equals("rating")) {
						items.add(xpp.getAttributeValue(0));
					}
					if (xpp.getName().equals("category")) {
						items.add(xpp.getAttributeValue(0));
					}
					if (xpp.getName().equals("image")) {
						items.add(xpp.getAttributeValue(0));
					}
					
				}

				xpp.next();
			}
		} catch (Throwable t) {
			Toast.makeText(this, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();
		}
				
		
		//take items and set to restaurant class
		Resturant newRestaurant = new Resturant();
		newRestaurant.setName(items.get(1));
		newRestaurant.setPhone(items.get(2));
		newRestaurant.setWebsite(items.get(3));
		newRestaurant.setRating(items.get(4));
		newRestaurant.setImage(items.get(5));
		
		resturants.add(newRestaurant);
		
		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
		
		 HashMap<String, String> map = new HashMap<String, String>();
		 map.put("name", newRestaurant.getName());
		 map.put("phone", newRestaurant.getPhone());
		 map.put("website", newRestaurant.getWebsite());
		 map.put("rating", newRestaurant.getRating());
		 map.put("category", newRestaurant.getCategory());
		 map.put("image", newRestaurant.getImage());
		 
		 menuItems.add(map);
		 
		 
		 LayoutInflater vi = (LayoutInflater)this.getSystemService
			      (Context.LAYOUT_INFLATER_SERVICE);

		        vi.inflate(R.layout.list_row, null);
		 
		        ImageView thumb_image=(ImageView)vi.findViewById(R.id.image); // thumb image
		        TextView name = (TextView)vi.findViewById(R.id.name); 
		        RatingBar rating = (RatingBar)vi.findViewById(R.id.rating);
		       
		 

		 
		        //TODO Setting all values in listview
		        name.setText(resturants.get(1).getName());
		        rating.setNumStars(resturants.get(1).getRating());
		        imageLoader.DisplayImage(resturants.get(1).getImage(), thumb_image);
		        
		    
		
		 
		 
		 //TODO set restaurant class to list_row
		 ListAdapter adapter = new SimpleAdapter(this, menuItems,
	                R.layout.list_row,
	                new String[] { "image", "name", "rating" }, new int[] {
	                        R.id.image, R.id.name, R.id.rating });
		
		setListAdapter(adapter);
		 
		//sets single list to list view
//		System.out.println(items);		
//		setListAdapter(new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, items)); 
				
				
				
		
				
//			// XML node keys
//			static final String KEY_ITEM = "resturant"; // parent node
//			static final String KEY_NAME = "name";
//			static final String KEY_PHONE = "phone";
//			static final String KEY_WEBSITE = "website";
//			static final String KEY_RATING = "rating";
//			static final String KEY_CATEGORY = "category";
//			static final String KEY_IMAGE = "image";
//				 
//			ListAdapter adapter = new SimpleAdapter(this, resturants, R.layout.list_row, new String[] {KEY_IMAGE, KEY_NAME, KEY_RATING});
//			
//			setListAdepter(adapter);
//
//		    // selecting single ListView item
//		    ListView lv = getListView();
//		            
//		    // listening to single list item click
//		    lv.setOnItemClickListener(new OnItemClickListener() {
//				
//		    	
//	});
					    
		    
		    
		    
	}
}