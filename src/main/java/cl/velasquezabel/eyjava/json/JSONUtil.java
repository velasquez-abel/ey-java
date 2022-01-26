package cl.velasquezabel.eyjava.json;

import java.util.ArrayList;
import java.util.List;

import cl.velasquezabel.eyjava.controller.UserController;
import cl.velasquezabel.eyjava.dto.MessageDTO;
import cl.velasquezabel.eyjava.dto.PhoneDTO;
import cl.velasquezabel.eyjava.dto.UserDTO;
import cl.velasquezabel.eyjava.logging.Logger;
import cl.velasquezabel.eyjava.logging.LoggingUtil;

public final class JSONUtil{

	private final static Logger<JSONUtil> logger = LoggingUtil.getLogger( JSONUtil.class );
	
	private JSONUtil(){
		
	}
	
	public final static UserJSON getUserJSON( UserDTO u ){
		logger.info("JSONUtil.getUserJSON");
		UserJSON j = new UserJSON();
		j.setActive(u.getActive());
		j.setName(u.getName());
		j.setEmail(u.getEmail());
		j.setPassword( u.getPassword());
		j.setCreated(u.getCreated());
		j.setModified(u.getModified());
		j.setTokenUUID(u.getToken());
		List<PhoneJSON> list = new ArrayList<PhoneJSON>();
		for( PhoneDTO pj : u.getPhones() ){
			list.add( getPhoneJSON(pj));
		}
		j.setPhones(list);
		return j;
	}
	
	public final static UserDTO getUserDTO( UserJSON u ){
		logger.info("JSONUtil.getUserDTO");
		UserDTO j = new UserDTO();
		j.setActive(u.getActive());
		j.setName(u.getName());
		j.setEmail(u.getEmail());
		j.setPassword( u.getPassword());
		j.setCreated(u.getCreated());
		j.setModified(u.getModified());
		j.setToken(u.getTokenUUID());
		List<PhoneDTO> list = new ArrayList<PhoneDTO>();
		for( PhoneJSON pj : u.getPhones() ){
			list.add( getPhoneDTO(pj));
		}
		j.setPhones(list);
		return j;
	}
	
	public final static MessageJSON getMessageJSON( MessageDTO m ){
		logger.info("JSONUtil.getMessageJSON");
		return null;
	}
	
	public final static MessageDTO getMessageDTO( MessageDTO m){
		logger.info("JSONUtil.getMessageDTO");
		return null;
	}
	
	public final static PhoneJSON getPhoneJSON( PhoneDTO d ){
		logger.info("JSONUtil.getPhoneJSON");
		PhoneJSON j = new PhoneJSON();
		j.setCountrycode(d.getCountryCode());
		j.setCitycode(d.getCityCode());
		j.setNumber( d.getNumber());
		return j;
	}
	
	public final static PhoneDTO getPhoneDTO( PhoneJSON j ){
		logger.info("JSONUtil.getPhoneDTO");
		PhoneDTO d = new PhoneDTO();
		d.setCountryCode(j.getCountrycode());
		d.setCityCode(j.getCitycode());
		d.setNumber(j.getNumber());
		return d;
	}
	
}