package cl.velasquezabel.eyjava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.velasquezabel.eyjava.json.PhoneJSON;
import cl.velasquezabel.eyjava.json.UserJSON;

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
	@GetMapping( value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserJSON> getAll (){
		ArrayList<UserJSON> list = new ArrayList<UserJSON>();
		ArrayList<PhoneJSON> phones = new ArrayList<PhoneJSON>();
		UserJSON userJSON = new UserJSON();
		PhoneJSON phoneJSON = new PhoneJSON();
		phones.add( phoneJSON );
		userJSON.setPhones(phones);
		list.add( userJSON );
		
		return list;
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
