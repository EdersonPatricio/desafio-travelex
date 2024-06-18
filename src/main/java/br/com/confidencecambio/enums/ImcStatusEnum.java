package br.com.confidencecambio.enums;

import java.util.stream.Stream;

import lombok.Getter;

@Getter
public enum ImcStatusEnum {

	MUITO_ABAIXO_DO_PESO( 0.0, 16.9, "Muito abaixo do peso" ),

	ABAIXO_DO_PESO( 17.0, 18.4, "Abaixo do peso" ),

	PESO_NORMAL( 18.5, 24.9, "Peso normal" ),

	ACIMA_DO_PESO( 25.0, 29.9, "Acima do peso" ),

	OBESIDADE_I( 30.0, 34.9, "Obesidade I" ),

	OBESIDADE_II( 35.0, 39.9, "Obesidade II (severa)" ),

	OBESIDADE_III( 40.0, 1000.0, "Obesidade III (morbida)" );

	private final Double minimo;

	private final Double maximo;

	private final String situacao;

	ImcStatusEnum( Double minimo, Double maximo, String situacao ) {
		this.minimo = minimo;
		this.maximo = maximo;
		this.situacao = situacao;
	}

	public static ImcStatusEnum obterImcStatusEnum( Double imc ) {
		return Stream.of( values() )
			.filter( item -> imc >= item.getMinimo() && imc <= item.getMaximo() )
			.findFirst()
			.orElseThrow( IllegalArgumentException::new );
	}
}
