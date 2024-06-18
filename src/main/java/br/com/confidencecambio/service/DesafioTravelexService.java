package br.com.confidencecambio.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import br.com.confidencecambio.enums.ImcStatusEnum;
import br.com.confidencecambio.request.ImcRequest;
import br.com.confidencecambio.response.ImcResponse;

@Service
public class DesafioTravelexService {

	/**
	 * Método que calcula o imc com base no peso e altura informados
	 * 
	 * @return response contendo o valor calculado
	 */
	public ImcResponse calcularIMC( ImcRequest request ) {
		var imc = new BigDecimal( Double.valueOf( request.getPeso() ) / Math.pow( request.getAltura(), 2 ) )
			.setScale( 1, RoundingMode.HALF_UP ).doubleValue();

		ImcStatusEnum imcStatusEnum = ImcStatusEnum.obterImcStatusEnum( imc );

		return new ImcResponse( imc, imcStatusEnum.getSituacao() );
	}
}
