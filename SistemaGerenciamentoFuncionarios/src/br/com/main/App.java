package br.com.main;
import br.com.model.*;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws SalarioInvalidoException {
		Scanner sc = new Scanner(System.in);
		GerenciadorFuncionarios gf = new GerenciadorFuncionarios();
		gf.carregarArquivo();
		int opcao;
		Cargo cargo = null;
		
		do {
			System.out.println("-----Bem Vindo-----");
			System.out.println("1 - Cadastrar funcionário");
			System.out.println("2 - Listar funcionários");
			System.out.println("3 - Buscar por cargo");
			System.out.println("4 - Folha de pagamento");
			System.out.println("5 - Salvar");
			System.out.println("0 - Sair");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome: ");
				String nome = sc.nextLine();
				System.out.println("Escolha o cargo:");
				System.out.println("1 - Desenvolvedor");
				System.out.println("2 - Gerente");
				System.out.println("3 - Analista");
				System.out.println("4 - Designer");
				System.out.println("5 - Suporte");
				int opcaoCargo = sc.nextInt();
				sc.nextLine();
				
				//Escolhe Categoria
				switch (opcaoCargo) {
				case 1: cargo = Cargo.DESENVOLVEDOR; break;
				case 2: cargo = Cargo.GERENTE; break;
				case 3: cargo = Cargo.ANALISTA; break;
				case 4: cargo = Cargo.DESIGNER; break;
				case 5: cargo = Cargo.SUPORTE; break;
				}
				System.out.println("Digite o Salário: ");
				double salario = sc.nextDouble();
				
				try {
					gf.cadastrarFuncionario(nome, cargo, salario);
				}catch (SalarioInvalidoException e) {
				    System.out.println(e.getMessage());
				}
				break;

			case 2:
				gf.listarFuncionarios();
				break;
				
			case 3:
				System.out.println("Escolha o cargo: ");
				System.out.println("1 - Desenvolvedor");
				System.out.println("2 - Gerente");
				System.out.println("3 - Analista");
				System.out.println("4 - Designer");
				System.out.println("5 - Suporte");
				opcaoCargo = sc.nextInt();
				sc.nextLine();
				
				
				//Escolhe Categoria
				switch (opcaoCargo) {
				case 1: cargo = Cargo.DESENVOLVEDOR; break;
				case 2: cargo = Cargo.GERENTE; break;
				case 3: cargo = Cargo.ANALISTA; break;
				case 4: cargo = Cargo.DESIGNER; break;
				case 5: cargo = Cargo.SUPORTE; break;
				}
				
				gf.buscarPorCargo(cargo);
				break;
			case 4:
			    System.out.println("Folha de pagamento: R$" + gf.folhaPagamento());
				break;
			case 5:
				gf.salvarArquivo();
				break;
			case 0:
				System.out.println("Encerrando....");
				break;
			default:
				System.out.println("Opção Invalida!");
				break;
			}
		}while(opcao != 0);
		
		sc.close();
	}

}
