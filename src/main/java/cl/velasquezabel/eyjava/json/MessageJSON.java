package cl.velasquezabel.eyjava.json;

import java.io.Serializable;

public final class MessageJSON implements Serializable{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}