package br.com.confidencecambio.model;

public class Pessoa {

	private Identificacao identificacao;

	public Pessoa( String nome ) {
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

	public String getNomeAbreviado() {
		return identificacao.getNomeAbreviado();
	}
}
