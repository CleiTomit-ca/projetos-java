package br.com.main;
import java.util.Scanner;
import br.com.model.ContaBancaria;
public class CaixaEletronico {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ContaBancaria conta = new ContaBancaria("Cleiton", 100);
		
		int opcao;
		
		do {
			System.out.printf("Bem vindo, %s !%n", conta.getNome());
			System.out.println("1 - Depositar");
			System.out.println("2 - Sacar");
			System.out.println("3 - Ver extrato");
			System.out.println("4 - Ver saldo");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma opção:");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Quanto desejar depositar: ");
				double valor = scanner.nextDouble();
				conta.depositar(valor);
				break;
			case 2:
				System.out.println("Quanto desejar sacar: ");
				valor = scanner.nextDouble();
				conta.sacar(valor);
				break;
			case 3:
				conta.verExtrato();
				break;
			case 4:
				System.out.printf("%s seu saldo: %.2f%n", conta.getNome(), conta.getSaldo());
				break;
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
