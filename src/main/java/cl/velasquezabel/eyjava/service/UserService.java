package cl.velasquezabel.eyjava.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.velasquezabel.eyjava.controller.UserController;
import cl.velasquezabel.eyjava.dto.MessageDTO;
import cl.velasquezabel.eyjava.dto.PhoneDTO;
import cl.velasquezabel.eyjava.dto.UserDTO;
import cl.velasquezabel.eyjava.entity.Phone;
import cl.velasquezabel.eyjava.entity.User;
import cl.velasquezabel.eyjava.logging.Logger;
import cl.velasquezabel.eyjava.logging.LoggingUtil;
import cl.velasquezabel.eyjava.repository.PhoneRepository;
import cl.velasquezabel.eyjava.repository.UserRepository;

public class UserService{

	Logger<UserService> logger = LoggingUtil.getLogger( UserService.class );
	
	private UserRepository repo;
	
	@Autowired
	PhoneRepository pr;
	
	protected UserService( UserRepository ur){
		this.repo = ur;
	}
	public MessageDTO insertUser( UserDTO userDTO ) throws Exception{
		
		MessageDTO msg = new MessageDTO();
		try{
			User user = new User();
			Date now = new Date();
			UUID uuid = UUID.randomUUID();
			user.setId(  uuid );
			user.setFullName(userDTO.getName() );
			user.setEmail( userDTO.getEmail() );
			user.setPassword(userDTO.getPassword());
			user.setToken( user.getId().toString());
			user.setCreated( now );
			user.setModified( now );
			user.setActive( Boolean.TRUE );//active by default
			user = repo.save(user);
			logger.info( "user saved" );
			for( PhoneDTO p: userDTO.getPhones() ){
				Phone phone = new Phone();
				phone.setUserId( uuid );
				phone.setCountryCode(p.getCountryCode());
				phone.setCityCode( p.getCityCode());
				phone.setNumber( p.getNumber());
				pr.save(phone);
			}
			logger.info( "user phone saved" );
			msg.setMessage( "user has been added" );
			logger.info( "user has been added" );
		}
		catch( Exception e ){
			logger.error( "error when adding user" );
			msg.setMessage( "error when adding user" );
			throw e;
		}
		return msg;
	}
	
	public UserDTO lookupUser(String id){
		logger.debug( "UserService.lookupUser" );
		UserDTO userDTO = new UserDTO();
		Optional<User> opt = repo.findById(UUID.fromString(id));
		if( opt.isPresent() ){
			logger.debug( "UserService.lookupUser opt.isPresent()" );
			User user = opt.get();
			userDTO.setId( user.getId().toString());
			userDTO.setName(user.getFullName());
			userDTO.setEmail( user.getEmail());
			userDTO.setPassword( user.getPassword());
			userDTO.setToken( user.getToken());
			userDTO.setCreated(user.getCreated());
			userDTO.setModified(user.getModified());
			userDTO.setLastLogin(user.getLastLogin());
			userDTO.setActive(user.getActive());
			List<PhoneDTO> phones = new ArrayList<PhoneDTO>();
			for( Phone p : user.getPhones()){
				PhoneDTO dto = new PhoneDTO();
				dto.setUserID( p.getUserId());
				dto.setCityCode(p.getCityCode());
				dto.setCountryCode(p.getCountryCode());
				dto.setNumber( p.getNumber());
				phones.add( dto );
			}
			userDTO.setPhones(phones);
		}
		return userDTO;
	}
	
	public List<UserDTO> lookupAll(){
		logger.debug( "UserService.lookupAll" );
		List<User> list = repo.findAll();
		List<UserDTO> listDTO = new ArrayList<UserDTO>();
		for( User u : list ){
			logger.debug( "UserService.lookupAll for( User u : list )" );
			UserDTO userDTO = new UserDTO();
			userDTO.setId( u.getId().toString()  );
			userDTO.setName(u.getFullName());
			userDTO.setEmail( u.getEmail());
			userDTO.setPassword( u.getPassword());
			userDTO.setToken( u.getToken());
			userDTO.setCreated(u.getCreated());
			userDTO.setModified(u.getModified());
			userDTO.setLastLogin(u.getLastLogin());
			userDTO.setActive(u.getActive());
			listDTO.add(userDTO);
			List<PhoneDTO> phones = new ArrayList<PhoneDTO>();
			for( Phone p : u.getPhones()){
				PhoneDTO dto = new PhoneDTO();
				dto.setUserID( p.getUserId());
				dto.setCityCode(p.getCityCode());
				dto.setCountryCode(p.getCountryCode());
				dto.setNumber( p.getNumber());
				phones.add( dto );
			}
			userDTO.setPhones(phones);
		}
		logger.info( "UserService.lookupAll done" );
		return listDTO;
	}
	
	public MessageDTO deleteUser(String id){
		logger.debug( "UserService.deleteUser" );
		MessageDTO msg = new MessageDTO();
		repo.deleteById(UUID.fromString(id));
		msg.setMessage( "user has been deleted" );
		logger.info( "user has been deleted" );
		return msg;
	}
	
	public MessageDTO updateUser(UserDTO userDTO) throws Exception{
		logger.debug( "UserService.updateUser" );
		MessageDTO msg = new MessageDTO();
		try{
			User user = new User();
			Date now = new Date();
			user.setId( UUID.fromString( userDTO.getId() ) );
			user.setFullName(userDTO.getName() );
			user.setEmail( userDTO.getEmail() );
			user.setPassword(userDTO.getPassword());
			user.setToken( user.getId().toString());
			user.setModified( now );
			user.setLastLogin(now);
			user.setActive( userDTO.getActive() );
			
			repo.save(user);
			msg.setMessage( "user has been updated" );
			logger.info( "user has been updated" );
		}
		catch( Exception e ){
			logger.error( "UserService.updateUser -> ".concat( e.getMessage()) );
			e.printStackTrace();
			msg.setMessage( "error when updating user" );
			throw e;
		}
		
		return msg;
	}


}