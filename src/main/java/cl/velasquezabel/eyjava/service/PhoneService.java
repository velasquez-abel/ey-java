package cl.velasquezabel.eyjava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.velasquezabel.eyjava.dto.MessageDTO;
import cl.velasquezabel.eyjava.dto.PhoneDTO;
import cl.velasquezabel.eyjava.dto.UserDTO;
import cl.velasquezabel.eyjava.repository.PhoneRepository;

public class PhoneService {
	private PhoneRepository repo;
	protected PhoneService(PhoneRepository pr){
		this.repo = pr;
	}
	
	public MessageDTO insertPhone( PhoneDTO phone ){
		return null;
	}
	
	public List<PhoneDTO> lookupPhones(String userID){
		return null;
	}
	
	public MessageDTO deletePhone(String id){
		return null;
	}
	
	public MessageDTO updatePhone(PhoneDTO phone){
		return null;
	}
}
