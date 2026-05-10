package br.com.model;

public class Despesa {
	// ATRIBUTOS
	private String descricao;
	private double valor;
	private Categoria categoria;
	
	//CONSTRUTOR
	public Despesa(String descricao, double valor, Categoria categoria) {
	 this.descricao = descricao;
	 this.valor = valor;
	 this.categoria = categoria;
	}
	
	//GETTERS & SETTERS
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
	 return descricao;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
	 return valor;
	}
	
	public Categoria getCategoria() {
	 return categoria;
	}
	
	
	
}
