package br.com.main;
import br.com.model.*;
import java.util.Scanner;

public class SistemaCadastro {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SistemaAluno sistemaAluno = new SistemaAluno();
		int opcao;
		
		do {
			System.out.println("Bem vindo");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Listar alunos");
			System.out.println("3 - Buscar Aluno");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome do aluno: ");
				String nome = scanner.nextLine();
				double[] notas = new double[3];
				for(int i = 0; i < notas.length; i++) {
					System.out.printf("Digita a %d nota: ", i + 1);
					notas[i] = scanner.nextDouble();
				}
				sistemaAluno.cadastrarAluno(nome, notas);
				break;
			case 2:
				sistemaAluno.listarAlunos();
				break;
			case 3:
				System.out.println("Digite o Nome: ");
				nome = scanner.nextLine();
				sistemaAluno.buscarAluno(nome);
				break;
			case 0:
				System.out.println("Ecerrando...");
				break;
			default:
				System.out.println("Opção Invalida!");
				break;
			}
		}while(opcao != 0);
		
		scanner.close();
	}
}
