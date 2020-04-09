package com.donateplus.donateplusapi.config.validacao;

/**
 * this class represent ErrorMessage from customize bean validation
 * 
 * @author j.a.vasconcelos
 *
 */
public class ErrorMessage {

	private String field;
	private String error;

	public ErrorMessage(String field, String error) {
		super();
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
