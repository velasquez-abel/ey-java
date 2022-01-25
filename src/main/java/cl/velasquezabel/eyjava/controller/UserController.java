package cl.velasquezabel.eyjava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	/**
	 * to create a user
	 * */
	@PostMapping("/user")
	public String create(){
		return "";
	}

	/**
	 * to get all users
	 * */
	@GetMapping("/user")
	public List<String> getAll (){
		return null;
	}
	
	/**
	 * to get a single particular user
	 * */
	@GetMapping("/user/{id}")
	public String getOne(String id){
		return null;
	}
	
	/**
	 * to update a single particular user
	 * */
	@PutMapping("/user/{id}")
	public String updateOne( String id){
		return "";
	}
	
	/**
	 * to remove a single particular user
	 * */
	@DeleteMapping("/user/{id}")
	public String delete( String id){
		return "";
	}
}
