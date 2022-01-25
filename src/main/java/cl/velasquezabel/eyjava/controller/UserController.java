package cl.velasquezabel.eyjava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.velasquezabel.eyjava.dto.MessageDTO;
import cl.velasquezabel.eyjava.dto.UserDTO;
import cl.velasquezabel.eyjava.json.JSONUtil;
import cl.velasquezabel.eyjava.json.MessageJSON;
import cl.velasquezabel.eyjava.json.PhoneJSON;
import cl.velasquezabel.eyjava.json.UserJSON;
import cl.velasquezabel.eyjava.logging.Logger;
import cl.velasquezabel.eyjava.logging.LoggingUtil;
import cl.velasquezabel.eyjava.service.ServiceLookup;

@RestController
public class UserController {
	
	Logger<UserController> logger = LoggingUtil.getLogger( UserController.class );
	
	/**
	 * to create a user
	 * */
	@PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageJSON create(@RequestBody UserJSON userJSON ){
		MessageJSON msg = new MessageJSON();
		logger.debug( "message catched on UserController.create for POST request /user" );
		try{
			UserDTO userDTO = JSONUtil.getUserDTO(userJSON);
			MessageDTO msgDTO = ServiceLookup.locateUserService().insertUser(userDTO);
			msg = JSONUtil.getMessageJSON(msgDTO);
		}
		catch(Exception e){
			msg.setMessage( e.getMessage() );
		}
		return msg;
	}

	/**
	 * to get all users
	 * */
	@GetMapping( value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserJSON> getAll (){
		logger.debug( "message catched on UserController.getAll for GET request /user" );
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
	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserJSON getOne(@RequestBody String request){
		logger.debug( "message catched on UserController.getOne for GET request /user/{id}" );
		ArrayList<PhoneJSON> phones = new ArrayList<PhoneJSON>();
		UserJSON userJSON = new UserJSON();
		PhoneJSON phoneJSON = new PhoneJSON();
		phones.add( phoneJSON );
		userJSON.setPhones(phones);
		return userJSON;
	}
	
	/**
	 * to update a single particular user
	 * */
	@PutMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageJSON updateOne( @RequestBody String request){
		logger.debug( "message catched on UserController.updateOne for PUT request /user/{id}" );
		return new MessageJSON();
	}
	
	/**
	 * to remove a single particular user
	 * */
	@DeleteMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageJSON delete( @RequestBody String request){
		logger.debug( "message catched on UserController.delete for DELETE request /user/{id}" );
		return new MessageJSON();
	}
}
