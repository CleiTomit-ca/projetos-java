package br.com.main;
import java.util.Scanner;
import br.com.model.*;

public class App {

	public static void main(String[] args) throws QuantidadeInvalidaException {
		GerenciadorProdutos gp = new GerenciadorProdutos();
		Scanner sc = new Scanner(System.in);
		int opcao;
		CategoriaProdutos categoriap = null;
		do {
			System.out.println("-----Bem Vindo-----");
			System.out.println("1 - Cadastra produto");
			System.out.println("2 - Listar todos os produtos");
			System.out.println("3 - Buscar por categoria");
			System.out.println("4 - Verificar estoque baixo");
			System.out.println("5 - Salvar produtos");
			System.out.println("6 - Carregar produtos");
			System.out.println("0 - Sair");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome: ");
				String nome = sc.nextLine();
				System.out.println("Escolha a categoria:");
				System.out.println("1 - Eletronicos");
				System.out.println("2 - Roupas");
				System.out.println("3 - Alimentos");
				System.out.println("4 - Beleza");
				System.out.println("5 - Casa");
				System.out.println("6 - Brinquedos");
				System.out.println("7 - Automotivo");
				System.out.println("8 - Saúde");
				System.out.println("9 - Papelaria");
				System.out.println("10 - PetShop");
				int opcaoCategoria = sc.nextInt();
				sc.nextLine();
				
				//Escolhe Categoria
				switch (opcaoCategoria) {
				case 1: categoriap = CategoriaProdutos.Eletronicos; break;
				case 2: categoriap = CategoriaProdutos.Roupas; break;
				case 3: categoriap = CategoriaProdutos.Alimentos; break;
				case 4: categoriap = CategoriaProdutos.Beleza; break;
				case 5: categoriap = CategoriaProdutos.Casa; break;
				case 6: categoriap = CategoriaProdutos.Brinquedos; break;
				case 7: categoriap = CategoriaProdutos.Automotivo; break;
				case 8: categoriap = CategoriaProdutos.Saude; break;
				case 9: categoriap = CategoriaProdutos.Papelaria; break;
				case 10: categoriap = CategoriaProdutos.PetShop; break;
				}
				System.out.println("Quantidade: ");
				int quantidade = sc.nextInt();
				System.out.println("Preço: ");
				double price = sc.nextDouble();
				
				try {
				    gp.cadastrarProdutos(nome, categoriap, quantidade, price);
				} catch(QuantidadeInvalidaException e) {
				    System.out.println(e.getMessage());
				}
				break;
			case 2:
				gp.listarProdutos();
				break;
			case 3:
				System.out.println("Escolha a categoria:");
				System.out.println("1 - Eletronicos");
				System.out.println("2 - Roupas");
				System.out.println("3 - Alimentos");
				System.out.println("4 - Beleza");
				System.out.println("5 - Casa");
				System.out.println("6 - Brinquedos");
				System.out.println("7 - Automotivo");
				System.out.println("8 - Saúde");
				System.out.println("9 - Papelaria");
				System.out.println("10 - PetShop");
				opcaoCategoria = sc.nextInt();
				sc.nextLine();
				
				switch (opcaoCategoria) {
				case 1: categoriap = CategoriaProdutos.Eletronicos; break;
				case 2: categoriap = CategoriaProdutos.Roupas; break;
				case 3: categoriap = CategoriaProdutos.Alimentos; break;
				case 4: categoriap = CategoriaProdutos.Beleza; break;
				case 5: categoriap = CategoriaProdutos.Casa; break;
				case 6: categoriap = CategoriaProdutos.Brinquedos; break;
				case 7: categoriap = CategoriaProdutos.Automotivo; break;
				case 8: categoriap = CategoriaProdutos.Saude; break;
				case 9: categoriap = CategoriaProdutos.Papelaria; break;
				case 10: categoriap = CategoriaProdutos.PetShop; break;
				}
				gp.buscarPorCategoria(categoriap);
				break;
			case 4:
				gp.verificarEstoque();
				break;
			case 5:
				gp.salvarProdutos();
				break;
			case 6:
				gp.carregarProdutos();
				break;
			case 0:
				System.out.println("Encerrando...");
				break;
			default:
				System.out.println("Opção Invalida!!!");
				break;
			}
		}while(opcao != 0);
		
		sc.close();
	}

}
