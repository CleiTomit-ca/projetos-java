package br.com.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaBiblioteca {
	//Listas
	private List<Livro> livros = new ArrayList<Livro>();
	private Set<String> isbns = new HashSet<String>();
	private Map<Categoria, List<Livro>> categorias = new HashMap<Categoria, List<Livro>>();
			
	//Cadastrar Livro
	public void cadastrarLivro(String titulo, String autor, double preco, String isbn, Categoria categoria) {
		if(isbns.contains(isbn)) {
		 System.out.println("ISBN Já Existe!!!");
		  return;
		}else {
		  Livro livro = new Livro(titulo, autor, preco, isbn, categoria);
		   livros.add(livro);
		   categorias.computeIfAbsent(categoria, k -> new ArrayList<>()).add(livro);
		   isbns.add(isbn);
		    System.out.println("Livro Adicionado com Sucesso!!!");
		}
	}
	
	//Listar Livros
	public void listarLivros() {
		System.out.println("Lista de livros: ");
		for(Livro livros: livros) {
			System.out.println("Titulo: " + livros.getTitulo());
			System.out.println("Autor: " + livros.getAutor());
			System.out.println("ISBN: " + livros.getIsbn());
			System.out.println("Categoria: " + livros.getCategoria());
			System.out.println("Preço: " + livros.getPreco());
			System.out.println("================================");
		}
	}
	
	//Buscar por autor
	public void buscarPorAutor(String autor) {
		boolean encontrado = false;
		System.out.println("Livros desse Autor: ");
		for(Livro l: livros) {
			if(l.getAutor().equals(autor)) {
				encontrado = true;
				System.out.println("Titulo: " + l.getTitulo());
				System.out.println("Autor: " + l.getAutor());
				System.out.println("ISBN: " + l.getIsbn());
				System.out.println("Categoria: " + l.getCategoria());
				System.out.println("Preço: " + l.getPreco());
				System.out.println("================================");
			}
		}
		if(!encontrado) {
			System.out.println("Nenhum livro encontrado para: " + autor);
		}
	}
	//Listar por categoria
	public void listarPorCategoria(Categoria categoria) {
	    List<Livro> livrosDaCategoria = categorias.get(categoria);
	    
	    if(livrosDaCategoria == null) {
	        System.out.println("Nenhum livro nessa categoria!");
	        return;
	    }
	    
	    for(Livro l: livrosDaCategoria) {
	        System.out.println("Categoria: " + l.getCategoria() + " -> " + "[" + l.getTitulo() + "]");
	    }
	}
}			
