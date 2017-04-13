package com.project.cassandra.service.impl;

import com.project.cassandra.service.LocationService;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.project.cassandra.constants.Constants;
import com.project.cassandra.helper.LocationHelper;
import com.project.cassandra.model.Location;

@Service("locationService")
public class LocationServiceImpl implements LocationService{
	
	private static Cluster cluster;
	private static Session session;

	Location locationObject = null;
	LocationHelper locationHelper=new LocationHelper();
	
	static{
		cluster = Cluster.builder().addContactPoints("127.0.0.1","127.0.0.2","127.0.0.3").build();
		session = cluster.connect("govacation");
	}

	public List<Location> findLandmarkByLocation(String location,int limit) {
		List<Location> landmarkList=new ArrayList<Location>();
		
		ResultSet rs=session.execute("select * from landmarks_by_location where location_name=? limit ?",location,limit);
		Iterator<Row> itr=rs.iterator();
		while(itr.hasNext()){
			Row row=itr.next();
			locationObject=locationHelper.checkLocationDetails(row);
			landmarkList.add(locationObject);
		}
		return landmarkList;
	}

	public List<Location> findActivitiesByLocation(String location,int limit) {
		List<Location> activitiesList=new ArrayList<Location>();
		
		ResultSet rs=session.execute("select * from activities_by_location where location_name=? limit ?",location,limit);
		Iterator<Row> itr=rs.iterator();
		while(itr.hasNext()){
			Row row=itr.next();
			locationObject=locationHelper.checkLocationDetails(row);
			activitiesList.add(locationObject);
		}
		return activitiesList;
		
	}

	public List<Location> findAccommodationByLocation(String location,int limit) {
		List<Location> accommodationList=new ArrayList<Location>();
		
		ResultSet rs=session.execute("select * from accommodations_by_location where location_name=? limit ?",location,limit);
		Iterator<Row> itr=rs.iterator();
		while(itr.hasNext()){
			Row row=itr.next();
			locationObject=locationHelper.checkLocationDetails(row);
			accommodationList.add(locationObject);
		}
		return accommodationList;
		
	}

	public List<Location> findRestaurantsByLocation(String location,int limit) {
		List<Location> restaurantList=new ArrayList<Location>();
		
		ResultSet rs=session.execute("select * from restaurants_by_location where location_name=? limit ?",location,limit);
		Iterator<Row> itr=rs.iterator();
		while(itr.hasNext()){
			Row row=itr.next();
			locationObject=locationHelper.checkLocationDetails(row);
			restaurantList.add(locationObject);
		}
		return restaurantList;
		
	}

	public List<Location> searchByLocation(String location) {
		List<Location> allCategories=new ArrayList<Location>();
		allCategories.addAll(findRestaurantsByLocation(location, 1));
		allCategories.addAll(findAccommodationByLocation(location, 1));
		allCategories.addAll(findLandmarkByLocation(location, 1));
		allCategories.addAll(findActivitiesByLocation(location, 1));
		return allCategories;
		
	}

	@Override
	public Location fetchLocationDetails(String location, String category, String place) {
		System.out.println(location);
		System.out.println(category);
		System.out.println(place);
		if(category.equalsIgnoreCase(Constants.LANDMARK)){
			ResultSet rs=session.execute("select * from landmarks_by_location where location_name=? and name=?",location,place);
			Row row=rs.one();
			locationObject=locationHelper.checkLocationDetails(row);
		}
		else if(category.equalsIgnoreCase(Constants.ACCOMMODATION)){
			ResultSet rs=session.execute("select * from accommodations_by_location where location_name=? and name=?",location,place);
			Row row=rs.one();
			locationObject=locationHelper.checkLocationDetails(row);
		}
		else if(category.equalsIgnoreCase(Constants.ACTIVITY)){
			ResultSet rs=session.execute("select * from activities_by_location where location_name=? and name=?",location,place);
			Row row=rs.one();
			locationObject=locationHelper.checkLocationDetails(row);
		}
		else if(category.equalsIgnoreCase(Constants.RESTAURANT)){
			ResultSet rs=session.execute("select * from restaurants_by_location where location_name=? and name=?",location,place);
			Row row=rs.one();
			locationObject=locationHelper.checkLocationDetails(row);
		}
		else{
			System.out.println("Wrong category");
			return null;
		}
		return locationObject;
	}

}
