package com.example.demo.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User class definition.
 * @author Rinegal1218
 */
@ApiModel(description = "User model example.")
public class User {
	
	@ApiModelProperty(notes = "", required = true, example = "John")
	private String firstName;
	
	@ApiModelProperty(notes = "", required = true, example = "Doe")
	private String lastName;
	
	@ApiModelProperty(notes = "", required = true, example = "johndoe@gmail.com")
	private String email;
	
	@ApiModelProperty(notes = "", required = true, example = "28")
	private int age;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
