package main;

import br.com.model.*;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		SistemaBiblioteca sistema = new SistemaBiblioteca();
		int opcao;
		Categoria categoria = null;
		do {
			System.out.println("Bem Vindo");
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Listar");
			System.out.println("3 - Buscar por autor");
			System.out.println("4 - Listar por categoria");
			System.out.println("0 - Sair");
			opcao = scanner.nextInt();
			scanner.nextLine();
			switch (opcao) {
			case 1:
				System.out.println("Escreva o titulo: ");
				String titulo = scanner.nextLine();
				System.out.println("Escreva o autor: ");
				String autor = scanner.nextLine();
				System.out.println("Escreva o preço: ");
				double preco = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Escreva o ISBN: ");
				String isbn = scanner.nextLine();
				System.out.println("Escolha a categoria:");
				System.out.println("1 - Tecnologia");
				System.out.println("2 - Ficção");
				System.out.println("3 - Bigrafia");
				System.out.println("4 - História");
				int opcaoCategoria = scanner.nextInt();
				scanner.nextLine();
				
				//Escolhe Categoria
				switch (opcaoCategoria) {
				case 1: categoria = Categoria.TECNOLOGIA; break;
				case 2: categoria = Categoria.FICCAO; break;
				case 3: categoria = Categoria.BIOGRAFIA; break;
				case 4: categoria = Categoria.HISTORIA; break;
				case 5 :categoria = Categoria.CIENCIA; break;
				}
				
				sistema.cadastrarLivro(titulo, autor, preco, isbn, categoria);
				break;
				
			case 2: 
				sistema.listarLivros();
				break;
			case 3: 
				System.out.println("Digite o nome do Autor:");
				autor = scanner.nextLine();
				sistema.buscarPorAutor(autor);
				break;
			case 4:
				System.out.println("Escolha a categoria:");
				System.out.println("1 - Tecnologia");
				System.out.println("2 - Ficção");
				System.out.println("3 - Bigrafia");
				System.out.println("4 - História");
				opcaoCategoria = scanner.nextInt();
				scanner.nextLine();
				
				//Escolhe Categoria
				switch (opcaoCategoria) {
				case 1: categoria = Categoria.TECNOLOGIA; break;
				case 2: categoria = Categoria.FICCAO; break;
				case 3: categoria = Categoria.BIOGRAFIA; break;
				case 4: categoria = Categoria.HISTORIA; break;
				case 5 :categoria = Categoria.CIENCIA; break;
				}
				sistema.listarPorCategoria(categoria);
				
				break;
			case 0:
				System.out.println("Encerrando...");
				break;
			default:
				System.out.println("Opção Invalida!");
				break;
			}
		}while(opcao != 0);
		
		scanner.close();
	}

}
