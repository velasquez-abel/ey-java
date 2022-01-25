package cl.velasquezabel.eyjava.json;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public final class UserJSON implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6865851036532145226L;
	private String name;
	private String email;
	private String password;
	private String tokenUUID;
	private List<PhoneJSON> phones;
	private Date created;
	private Date modified;
	private Boolean active;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTokenUUID() {
		return tokenUUID;
	}
	public void setTokenUUID(String tokenUUID) {
		this.tokenUUID = tokenUUID;
	}
	public List<PhoneJSON> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneJSON> phones) {
		this.phones = phones;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}