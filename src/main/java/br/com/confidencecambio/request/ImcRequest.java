package br.com.confidencecambio.request;

import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImcRequest {

	@JsonProperty( "peso" )
	@DecimalMin( value = "0.0", inclusive = false, message = "O peso deve ser maior que 0" )
	private Double peso;

	@JsonProperty( "altura" )
	@DecimalMin( value = "0.0", inclusive = false, message = "A altura deve ser maior que 0" )
	private Double altura;

}
