package br.com.confidencecambio.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude( Include.NON_NULL )
public class Problema {

	private Integer status;
	
	private String titulo;

	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt", timezone="GMT-3" )
	private LocalDateTime dataHora;
	
	private List<Campo> campos;

	public Problema( Integer status, String titulo, LocalDateTime dataHora ) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.dataHora = dataHora;
	}
}
