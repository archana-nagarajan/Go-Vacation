package com.project.cassandra.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

	private String locationId;
	private String locationName;
	private float latitude;
	private float longitude;
	private String images;
	private String locationAddress;
	private float rating;
	private String review;
	private String description;
	private String detailedDescription;
	
	public Location(String locationId, String locationName, float latitude, float longitude, String images,
			String locationAddress, float rating, String review, String description, String detailedDescription) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.images = images;
		this.locationAddress = locationAddress;
		this.rating = rating;
		this.review = review;
		this.description = description;
		this.detailedDescription = detailedDescription;
	}
	
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getLocationAaddress() {
		return locationAddress;
	}
	public void setLocationAaddress(String locationAaddress) {
		this.locationAddress = locationAaddress;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
}
