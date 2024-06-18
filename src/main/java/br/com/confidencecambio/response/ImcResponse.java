package br.com.confidencecambio.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImcResponse {

	@JsonProperty( "imc" )
	private Double imc;
	
	@JsonProperty( "situacao" )
	private String situacao;
}
