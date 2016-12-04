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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.cassandra.model.User;
import com.project.cassandra.service.UserService;
 
@RestController
public class UserDetailsController{
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Add new users--------------------------------------------------------
     
    @RequestMapping(value = "/addPerson", method = RequestMethod.POST, headers = {"Content-type=application/json"})
		@ResponseBody
		public void addPerson(@RequestBody User user) {
    	userService.saveUserDetails(user);
		}
 
}