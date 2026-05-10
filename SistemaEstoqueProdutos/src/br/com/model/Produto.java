package br.com.model;

public class Produto {
	private String nome;
	private double price;
	private int quantidade;
	private CategoriaProdutos categorias;
	
	public Produto(String nome,CategoriaProdutos categorias,int quantidade, double price) {
		this.nome = nome;
		this.categorias = categorias;
		this.quantidade = quantidade;
		this.price = price;
	}

	public String getNome() {
		return nome;
	}
	
	public CategoriaProdutos getCategorias() {
		return categorias;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public double getPrice() {
		return price;
	}

	
}
