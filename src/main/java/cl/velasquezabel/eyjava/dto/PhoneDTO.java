package cl.velasquezabel.eyjava.dto; 

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public final class PhoneDTO{
	
	@NotNull(message = "country code can not be null")
	@Size(min = 1, max =3, message = "country code must be a value with 1 to 3 numbers")
	@Positive
	private String countryCode;

	@NotNull(message = "city code can not be null")
	@Size(min = 1, max =3, message = "city code must be a value with 1 to 3 numbers")
	@Positive
	private String cityCode;

	@NotNull(message = "phone number can not be null")
	@Size(min = 5 , message = " phone number must be a value with at least 5 numbers")
	@Positive
	private String number;	
}
