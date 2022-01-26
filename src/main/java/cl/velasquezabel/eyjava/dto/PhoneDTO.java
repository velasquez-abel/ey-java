package cl.velasquezabel.eyjava.dto; 

import java.util.UUID;

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

	private UUID userID;
	
	public UUID getUserID() {
		return userID;
	}

	public void setUserID(UUID userID) {
		this.userID = userID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}	
}
