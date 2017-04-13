package com.project.cassandra.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.project.cassandra.model.Location;
import com.project.cassandra.service.LocationService;
 
@RestController
public class FetchByLocationController{
 
    @Autowired
    LocationService locationService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve landmarks by location name--------------------------------------------------------
     
    @RequestMapping(value = "/landmarks/{location_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getLandmarkResultsByLocation(@PathVariable("location_name") String location) {
    	List<Location> landmarks = locationService.findLandmarkByLocation(location,4);
        if(landmarks.isEmpty()){
            return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Location>>(landmarks, HttpStatus.OK);
    }
 
    //-------------------Retrieve activities by location name--------------------------------------------------------
    
    @RequestMapping(value = "/activities/{location_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getActivityResultsByLocation(@PathVariable("location_name") String location) {
    	List<Location> activities = locationService.findActivitiesByLocation(location,4);
        if(activities.isEmpty()){
            return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Location>>(activities, HttpStatus.OK);
    }
    
    //-------------------Retrieve accommodations by location name--------------------------------------------------------
 
    @RequestMapping(value = "/accommodations/{location_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getAccommodationResultsByLocation(@PathVariable("location_name") String location) {
    	List<Location> accommodations = locationService.findAccommodationByLocation(location,4);
        if(accommodations.isEmpty()){
            return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Location>>(accommodations, HttpStatus.OK);
    }
    
    //-------------------Retrieve restaurants by location name--------------------------------------------------------
 
    @RequestMapping(value = "/restaurants/{location_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getRestaurantResultsByLocation(@PathVariable("location_name") String location) {
    	List<Location> restaurants = locationService.findRestaurantsByLocation(location,4);
        if(restaurants.isEmpty()){
            return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Location>>(restaurants, HttpStatus.OK);
    }
        
    //-------------------Retrieve all categories by location name--------------------------------------------------------
    
    @RequestMapping(value = "/locations/{location_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getResultsByLocation(@PathVariable("location_name") String location) {
    	List<Location> locations = locationService.searchByLocation(location);
        if(locations.isEmpty()){
            return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
    }
 
    //-------------------Retrieve location details--------------------------------------------------------
    
    @RequestMapping(value = "/locations/{category}/{location_name}/{place_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getLocationDetails(@PathVariable("location_name") String location,@PathVariable("category") String category, @PathVariable("place_name") String place){
    	Location locationObject=locationService.fetchLocationDetails(location,category,place);
        if(locationObject==null){
            return new ResponseEntity<Location>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Location>(locationObject, HttpStatus.OK);
    }
}