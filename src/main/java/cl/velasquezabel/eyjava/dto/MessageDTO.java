package cl.velasquezabel.eyjava.dto; 

import javax.validation.constraints.NotNull;

public final class MessageDTO{
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@NotNull
	private String message;
}

