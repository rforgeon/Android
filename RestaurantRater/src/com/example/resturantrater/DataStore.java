package com.example.resturantrater;

import java.util.ArrayList;



public class DataStore {

	
	private static DataStore ref;
	private DataStore(){}
	
	private ArrayList<Resturant> resturantList = new ArrayList<Resturant>();
	
	
	public static DataStore getInstance(){
		if (ref == null){
			ref = new DataStore();
		}
		return ref;
	}
	
	public ArrayList<Resturant> getResturantList(){
		return resturantList;
	}
	
	public void setResturantList(ArrayList <Resturant> c){
		resturantList = c;
		
	}
}
