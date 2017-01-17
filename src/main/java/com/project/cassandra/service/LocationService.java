package com.project.cassandra.service;

import java.util.List;
import com.project.cassandra.model.Location;

public interface LocationService {
	
	public List<Location> findLandmarkByLocation(String location,int limit);
	
	public List<Location> findActivitiesByLocation(String location, int limit);
	
	public List<Location> findAccommodationByLocation(String location, int limit);
	
	public List<Location> findRestaurantsByLocation(String location, int limit);
	
	public List<Location> searchByLocation(String location);
	
	public Location fetchLocationDetails(String location, String category, String place);

}
