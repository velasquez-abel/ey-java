package cl.velasquezabel.eyjava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.velasquezabel.eyjava.json.MessageJSON;
import cl.velasquezabel.eyjava.json.PhoneJSON;

@RestController
public class PhoneController {

	/**
	 * to add a new phone number to a userID
	 * */
	@PostMapping("/phone/{id}")
	public MessageJSON addPhone(String userID){
		return null;
	}
	
	/**
	 * to get all phones added to a userID
	 * */
	@GetMapping("/phone/id")
	public List<PhoneJSON> getPhone(String userID){
		return null;
	} 
}
