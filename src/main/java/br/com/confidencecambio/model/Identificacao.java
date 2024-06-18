package br.com.confidencecambio.model;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Identificacao {

	@NotEmpty( message = "Campo NOME é requerido!" )
	@NotBlank( message = "Campo NOME está em branco!" )
	private String nome;

	public Identificacao( String nome ) {
		setNome( nome );
	}

	private void validarNome( String nome ) {
		if ( nome == null || nome.trim().isEmpty() ) {
			throw new IllegalArgumentException( "O nome não pode ser nulo ou vazio." );
		}
	}
	
	public String getNome() {
		return nome;
	}

	// Validação do nome e remoção de espaços extras
	public void setNome( String nome ) {
		validarNome( nome );
		this.nome = nome.trim();
	}

	// Obtém o primeiro nome
	public String getPrimeiroNome() {
		return nome.split( "\\s+" )[0];
	}

	// Obtém o último nome (todas as partes exceto o primeiro nome)
	public String getUltimoNome() {
		String[] partes = nome.split( "\\s+" );
		if ( partes.length > 1 ) {
			return String.join( " ", Arrays.copyOfRange( partes, 1, partes.length ) );
		}
		return nome;
	}

	// Retorna o nome todo em letras maiúsculas
	public String getNomeMaiusculo() {
		return nome.toUpperCase();
	}

	// Retorna o nome abreviado
	public String getNomeAbreviado() {
		String[] partes = nome.split( "\\s+" );
		if ( partes.length > 1 ) {
			StringBuilder abreviado = new StringBuilder( partes[0] );
			for ( int i = 1; i < partes.length - 1; i++ ) {
				abreviado.append( " " ).append( partes[i].charAt( 0 ) ).append( "." );
			}
			abreviado.append( " " ).append( partes[partes.length - 1] );
			
			return abreviado.toString();
		}
		// Se o nome tiver apenas uma parte, retorna o nome inteiro
		return nome;
	}
}
