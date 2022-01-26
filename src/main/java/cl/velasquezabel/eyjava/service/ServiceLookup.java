package cl.velasquezabel.eyjava.service;

import cl.velasquezabel.eyjava.repository.PhoneRepository;
import cl.velasquezabel.eyjava.repository.UserRepository;

public final class ServiceLookup {
	
	
	private ServiceLookup(){
		
	}
	
	public static UserService locateUserService( UserRepository repo){
		return new UserService( repo );
	}
	public static PhoneService locatePhoneService( PhoneRepository repo){
		return new PhoneService(repo );
	}
}
