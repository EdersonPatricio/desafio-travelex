package br.com.confidencecambio.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.confidencecambio.exception.CoreException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler( CoreException.class )
	public ResponseEntity<Object> handleEnderecoNaoEncontradoException( CoreException ex, WebRequest request ) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Problema problem = new Problema( status.value(), ex.getMessage(), LocalDateTime.now() );

		return handleExceptionInternal( ex, problem, new HttpHeaders(), status, request );
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request ) {
		Problema problem = new Problema( status.value(), "Campo(s) invalido(s). Preencha corretamente e tente novamente.", LocalDateTime.now() );
		
		List<Campo> campos = new ArrayList<Campo>();
		for ( ObjectError e: ex.getBindingResult().getAllErrors() ) {
			campos.add( new Campo( ( (FieldError) e ).getField(), e.getDefaultMessage() ) );
		}
		problem.setCampos( campos );
		
		return super.handleExceptionInternal( ex, problem, headers, status, request );
	}
}
