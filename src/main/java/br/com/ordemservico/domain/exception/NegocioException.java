package br.com.ordemservico.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegocioException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NegocioException(String msg) {
		super(msg);
	}

}
