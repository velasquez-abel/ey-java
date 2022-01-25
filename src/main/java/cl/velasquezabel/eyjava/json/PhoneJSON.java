package cl.velasquezabel.eyjava.json;

import java.io.Serializable;

public final class PhoneJSON implements Serializable{
	private String countryCode;
	private String cityCode;
	private String number;
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
