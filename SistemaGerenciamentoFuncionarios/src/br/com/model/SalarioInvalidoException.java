package br.com.model;


@SuppressWarnings("serial")
public class SalarioInvalidoException extends Exception {
	public SalarioInvalidoException(String mensagem) {
		super(mensagem);
	}
}
