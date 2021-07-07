package br.com.zupacademy.gabriel.casadocodigo.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidatorError extends StandardError {
	
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();
	
	public ValidatorError(Long timeStamp, Integer status, String message) {
		super(timeStamp, status, message);
		// TODO Auto-generated constructor stub
	}


	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName,  message));
	}


}
