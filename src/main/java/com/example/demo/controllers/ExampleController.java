package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class handle petitions of Swagger example.
 * @author Rinegal1218
 */
@RestController
@RequestMapping("/swagger-example")
@Api(tags = "Swagger Description")
public class ExampleController {
	
	//Dependency injection for UserService.
	@Autowired
	private UserService userService;

	/**
	 * This method handles petitions to list all users. 
	 * @return ResponseEntity object.
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = User.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "You do not have permission to do this action"),
			@ApiResponse(code = 403, message = "You can access this method"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "List all users.")
	public ResponseEntity<?> getAll() {
		Map<String, Object> response = new HashMap<>();
		response.put("users", userService.getAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * This method handles petitions to get an user. 
	 * @return ResponseEntity object.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 401, message = "You do not have permission to do this action"),
			@ApiResponse(code = 403, message = "You can access this method"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "List one user.")
	public ResponseEntity<?> getOne() {
		Map<String, Object> response = new HashMap<>();
		response.put("user", userService.getOne());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * This method handles petitions to create a new user.
	 * @param User object.
	 * @return ResponseEntity object.
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 401, message = "You do not have permission to do this action"),
			@ApiResponse(code = 403, message = "You can access this method"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "Create a new user.")
	public ResponseEntity<?> create(
			@ApiParam(value = "User object with the new data.", required = true)
			@RequestBody User user) {
		Map<String, Object> response = new HashMap<>();
		response.put("user_created", userService.create());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * This method handles petitions to update data of an user.
	 * @param User object.
	 * @return ResponseEntity object.
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 401, message = "You do not have permission to do this action"),
			@ApiResponse(code = 403, message = "You can access this method"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "Update data of an user.")
	public ResponseEntity<?> update(
			@ApiParam(value = "User object with the new data.", required = true)
			@RequestBody User user) {
		Map<String, Object> response = new HashMap<>();
		response.put("user_updated", userService.update(user));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * This method handles petitions to delete an user.
	 * @return ResponseEntity object.
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = User.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "You do not have permission to do this action"),
			@ApiResponse(code = 403, message = "You can access this method"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "Delete an user.")
	public ResponseEntity<?> delete() {
		Map<String, Object> response = new HashMap<>();
		response.put("users", userService.delete());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
