package cl.velasquezabel.eyjava.service;

import cl.velasquezabel.eyjava.dto.MessageDTO;
import cl.velasquezabel.eyjava.dto.UserDTO;

public class UserService{

	@Autowired
	private UserRepository repository;

	protected UserService(){
		
	}
	public MessageDTO insertUser( UserDTO userDTO ){
		User user = new User();
		user.set( userDTO.get );
		
		repository.save(user);
	}
	
	public UserDTO lookupUser(String id){
		User user = repository.find(id);
		UserDTO userDTO = new UserDTO();
		userDTO.set( user.get );
		
		return userDTO;
	}
	
	public List<UserDTO> lookupAll(){
		List<User> list = repository.findAll();
		List<UserDTO> listDTO = new ArrayList<UserDTO>();
		for( User u : list ){
			UserDTO dto = new UserDTO();
			dto.set( u.get() );
		}
		return listDTO;
	}
	
	public MessageDTO deleteUser(String id){
		MessageDTO msg = new MessageDTO();
		repository.remove(id);
		msg.setMessage( "user has been deleted" );
		return msg;
	}
	
	public MessageDTO updateUser(UserDTO user){
		MessageDTO msg = new MessageDTO();
		User user = new User();
		user.set( userDTO.get );
		
		repository.save(user);
		msg.setMessage( "user has been updated" );
		return msg;
	}


}