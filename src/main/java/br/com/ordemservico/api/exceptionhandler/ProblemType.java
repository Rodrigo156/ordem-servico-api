package br.com.ordemservico.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	PARAMETRO_INVALIDO("Parametro Invalido", "/parametro-invalido"),
	
	ARGUMENTO_INVALIDO("Argumento Inválido","/argumento-invalido");


	private String title;
	private String url;
	
	ProblemType(String title , String url){
		this.title = title;
		this.url = url;
	}

	
}
