package cl.velasquezabel.eyjava.dto; 

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public final class UserDTO{
	private String name;

	@Email(message = "Email should be valid")
	private String email;

	@Size(min = 1, message= "at least one phone number must be provided")
	private List<PhoneDTO> phones;	
}
