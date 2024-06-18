package br.com.confidencecambio.model;

public class Robo {

	private Identificacao identificacao;

	public Robo( String nome ) {
		this.identificacao = new Identificacao( nome );
	}
	
	public String getPrimeiroNome() {
		return identificacao.getPrimeiroNome();
	}

	public String getUltimoNome() {
		return identificacao.getUltimoNome();
	}

	public String getNomeMaiusculo() {
		return identificacao.getNomeMaiusculo();
	}
}
