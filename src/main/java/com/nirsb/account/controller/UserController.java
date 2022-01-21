package com.nirsb.account.controller;

import com.nirsb.account.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nirsb.account.model.User;
import com.nirsb.account.service.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Collections;
import java.util.List;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/users" , method= RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody User user){
		com.nirsb.account.model.dto.User user1 =  userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(user1.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(path = "/users/{userId}" , method= RequestMethod.GET)
	public ResponseEntity<Resource<com.nirsb.account.model.User>> getUser(@PathVariable long userId){
		com.nirsb.account.model.User user1 =  userService.getUser(userId);
		if(user1 == null){
			throw new UserNotFoundException("User Not Found Exception");
		}
		Resource<com.nirsb.account.model.User> resource = new Resource(user1);
		ControllerLinkBuilder controllerLinkBuilder = linkTo(methodOn(this.getClass()).getAllUser());
		resource.add(controllerLinkBuilder.withRel("all-users"));
		return new ResponseEntity<Resource<com.nirsb.account.model.User>>(resource,HttpStatus.OK);
		
	}

	@RequestMapping(path = "/users" , method= RequestMethod.GET)
	public ResponseEntity<List<com.nirsb.account.model.User>> getAllUser(){
		List<User> user1 =  userService.getUsers();
		if(CollectionUtils.isEmpty(user1)){
			throw new UserNotFoundException("User Not Found Exception");
		}
		return new ResponseEntity<List<com.nirsb.account.model.User>>(user1,HttpStatus.OK);

	}

	@RequestMapping(path = "/users/{userId}" , method= RequestMethod.DELETE)
	public ResponseEntity<Resource<com.nirsb.account.model.User>> deleteUserById(@PathVariable long userId){
		String message = "User deleted successfully";
		userService.deleteUser(userId);
		return new ResponseEntity<Resource<com.nirsb.account.model.User>>(HttpStatus.OK);

	}
	
}
