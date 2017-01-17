package com.project.cassandra.model;

import java.util.HashMap;
import java.util.Map;

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String id;
	private String imageUrl;
	private Map<String,Float> rating=new HashMap<String,Float>();
	private Map<String,String> review=new HashMap<String,String>();
	
	
	public Map<String, Float> getRating() {
		return rating;
	}
	public void setRating(Map<String, Float> rating) {
		this.rating = rating;
	}
	public Map<String, String> getReview() {
		return review;
	}
	public void setReview(Map<String, String> review) {
		this.review = review;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
