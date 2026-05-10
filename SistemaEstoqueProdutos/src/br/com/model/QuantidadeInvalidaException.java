package br.com.model;

@SuppressWarnings("serial")
public class QuantidadeInvalidaException extends Exception {
	public QuantidadeInvalidaException(String messagem) {
		 super(messagem);
	}
}
