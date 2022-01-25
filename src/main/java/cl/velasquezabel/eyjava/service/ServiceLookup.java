package cl.velasquezabel.eyjava.service;

import java.util.HashMap;
import java.util.Map;

public final class ServiceLookup {
	
	private static enum AVAIL_NAMES{
		UserService("UserService"),
		PhoneService("PhoneService");
		public final String label;
		private AVAIL_NAMES(String service){
			this.label = service;
		}
	}
	 
	private static UserService userService = new UserService();
	private static PhoneService phoneService = new PhoneService();
	
	private ServiceLookup(){
		
	}
	
	public static UserService locateUserService(){
		return userService;
	}
	public static PhoneService locatePhoneService(){
		return phoneService;
	}
}
