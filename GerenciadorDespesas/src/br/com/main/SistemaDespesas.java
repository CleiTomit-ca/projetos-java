package br.com.main;
import br.com.model.*;
import java.util.Scanner;
public class SistemaDespesas {
	
	public static void main(String[] args) {
		//Objetos
		Scanner scanner = new Scanner(System.in);
		GerenciadorDespesas gerenciador = new GerenciadorDespesas();
		
		//Atributos	
		int opcao;
		Categoria categoria = null;
		
		// MENU
		do {
			System.out.println("Bem Vindo");
			System.out.println("1 - Adicionar despesa");
			System.out.println("2 - Listar despesas");
			System.out.println("3 - Total por categoria");
			System.out.println("4 - Total geral");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			switch (opcao) {
			//Adicionar Despesa
			case 1:
				System.out.println("Digite uma Descrição da despesa:");
				String descricao = scanner.nextLine();
				System.out.println("Digite o valor da despesa:");
				double valor = scanner.nextDouble();
				System.out.println("Escolha a categoria:");
				System.out.println("1 - Alimentação");
				System.out.println("2 - Transporte");
				System.out.println("3 - Saúde");
				System.out.println("4 - Lazer");
				int opcaoCategoria = scanner.nextInt();
				scanner.nextLine();
				
				//Escolhe Categoria
				switch (opcaoCategoria) {
				case 1: categoria = Categoria.ALIMENTACAO; break;
				case 2: categoria = Categoria.TRANSPORTE; break;
				case 3: categoria = Categoria.SAUDE; break;
				case 4: categoria = Categoria.LAZER; break;
				}
				
				Despesa despesa = new Despesa(descricao, valor, categoria);	
				gerenciador.adicionarDespesa(despesa);
				break;
				
			//Listar todas as Despesas
			case 2: 
				gerenciador.listarDespesa();
				break;
			//Listar total por categoria
			case 3: 
				gerenciador.totalPorCategoria();
				break;
			//Total Geral
			case 4:
				System.out.println("TOTAL: " + gerenciador.totalGeral());
				break;
			//Sair
			case 0:
				System.out.println("Ecerrando...");
				break;
			default:
				System.out.println("Opção Invalida!!!");
				break;
			}
			
		}while(opcao != 0);
		
		
		scanner.close();
	}
}
