package com.project.cassandra.helper;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Row;
import com.project.cassandra.model.Location;

public class LocationHelper {
	
	public Location checkLocationDetails(Row row) {
		
		String locationId=row.getUUID("id").toString();
		String locationName=row.getString("name");
		float latitude=row.getFloat("latitude");
		float longitude=row.getFloat("longitude");;
		String images=row.getString("image");
		String locationAddress=row.getString("address");
		float rating=row.getFloat("rating");;
		String review=row.getString("review");
		String description=row.getString("description");
		String detailedDescription=row.getString("detailed_description");
		Location location=new Location(locationId, locationName, latitude, longitude, images, locationAddress, rating, review, description, detailedDescription);
		return location;
	}

}
