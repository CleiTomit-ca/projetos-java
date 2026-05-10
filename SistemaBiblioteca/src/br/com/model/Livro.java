package br.com.model;

public class Livro {
	private String titulo;
	private String autor;
	private double preco;
	private String isbn;
	private Categoria categoria;
	
	public Livro(String titulo, String autor, double preco, String isbn, Categoria categoria) {
	    this.titulo = titulo;
	    this.autor = autor;
	    this.preco = preco;
	    this.isbn = isbn;
	    this.categoria = categoria;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public String getIsbn() {
		return isbn;
	}
}	
