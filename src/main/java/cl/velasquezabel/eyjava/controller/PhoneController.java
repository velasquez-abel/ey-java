package cl.velasquezabel.eyjava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.velasquezabel.eyjava.json.MessageJSON;
import cl.velasquezabel.eyjava.json.PhoneJSON;
import cl.velasquezabel.eyjava.logging.Logger;
import cl.velasquezabel.eyjava.logging.LoggingUtil;

@RestController
public class PhoneController {
	Logger<PhoneController> logger = LoggingUtil.getLogger( PhoneController.class );

	/**
	 * to add a new phone number to a userID
	 * */
	@PostMapping("/phone/{id}")
	public MessageJSON addPhone(String id){
		logger.debug( "message catched on PhoneController.addPhone for POST request /phone/{id}" );
		return null;
	}
	
	/**
	 * to get all phones added to a userID
	 * */
	@GetMapping("/phone/{id}")
	public List<PhoneJSON> getPhone(String id){
		logger.debug( "message catched on PhoneController.getPhone for GET request /phone/{id}" );
		return null;
	} 
}
