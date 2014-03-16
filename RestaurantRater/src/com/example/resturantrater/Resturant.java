package com.example.resturantrater;

public class Resturant {

	String name;
	String phone;
	String website;
	int rating;
	String category;
	String image;

	public Resturant(){};

	//setters
	public void setName(String name){
		this.name = name;
		
	}
	public void setPhone(String phone){
		this.phone = phone;
		
	}
	public void setWebsite(String website){
		this.website = website;
		
	}
	public void setRating(int rating){
		this.rating = rating;
		
	}
	public void setCategory(String category){
		this.category = category;
		
	}
	public void setImage(String image){
		this.category = image;
		
	}

	//getters
	public String getName(){
		return this.name;
	}

	public String getPhone(){
		return this.phone;
	}

	public String getWebsite(){
		return this.website;
	}
	public int getRating(){
		return this.rating;
	}

	public String getCategory(){
		return this.category;
	}
	public String getImage(){
		return this.image;
	}
	
	
}
