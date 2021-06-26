package br.com.ordemservico.api.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	
	@Autowired
	private MessageSource messageSource;
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	    BindingResult bindingResult = ex.getBindingResult();
	   
	    	List<Problem.Field> problemObjects = bindingResult.getAllErrors().stream()
	    		.map(objectError -> {
	    			String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
	    			
	    			String name = objectError.getObjectName();
	    			
	    			if (objectError instanceof FieldError) {
	    				name = ((FieldError) objectError).getField();
	    			}
	    			
	    			return Problem.Field.builder()
	    				.name(name)
	    				.userMessage(message)
	    				.build();
	    		}).collect(Collectors.toList());
	    
		String detail = "Um ou mais campos são invalidos. Faça o preenchimento correto";
		
		
		Problem problem = createProblemBuilder(
				status,
				ProblemType.ARGUMENTO_INVALIDO,
				detail)
				.userMessage(detail)
				.fields(problemObjects).build();
		
		return handleExceptionInternal(ex,problem,new HttpHeaders(),status,request);
	}
	
	
	
	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status ,  ProblemType problemType, String detail){
			return Problem.builder()
						.status(status.value())
						.title(problemType.getTitle())
						.type(problemType.getUrl())
						.detail(detail);
}
	
	
}
