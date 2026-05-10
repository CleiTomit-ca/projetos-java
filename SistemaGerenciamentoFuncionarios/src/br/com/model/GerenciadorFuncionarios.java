  package br.com.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GerenciadorFuncionarios {
	private List<Funcionario> funcionario = new ArrayList<Funcionario>();
	private Map<Cargo, List<Funcionario>> cargos = new HashMap<Cargo , List<Funcionario>>();
	final String CAMINHO = "/home/cleiton/Java_Backend/SistemaGerenciamentoFuncionarios/src/br/com/model/Funcionarios.txt";
	
	public void cadastrarFuncionario(String nome, Cargo cargo, double salario) throws SalarioInvalidoException {
		if(salario < 0) {
	        throw new SalarioInvalidoException("Salário não pode ser negativo: " + salario);
	    }
		Funcionario f = new Funcionario(nome, cargo, salario);
		funcionario.add(f);
		cargos.computeIfAbsent(cargo, k -> new ArrayList<>()).add(f);
		System.out.println("Funcionario cadastrado!");
	}
	
	public void listarFuncionarios() {
		for(Funcionario f: funcionario) {
			System.out.println("Nome: " + f.getNome());
			System.out.println("Cargo: " + f.getCargo());
			System.out.println("Salário: " + f.getSalario());
			System.out.println("===============================");
		}
	}
	
	public void buscarPorCargo(Cargo cargo) {
		List<Funcionario> funcionariosCargo = cargos.get(cargo);
		
		if(funcionariosCargo == null) {
	        System.out.println("Nenhum cargo encontrado");
	        return;
	    }
		
		for(Funcionario f: funcionariosCargo) {
			System.out.println("Cargo: " + f.getCargo() + " -> " + f.getNome());
		}
	}
	
	public double folhaPagamento() {
		double soma = 0;
		for(Funcionario f: funcionario) {
			soma += f.getSalario();
		}
		return soma;
	}
	
	public void salvarArquivo() {
		try(FileWriter fw = new FileWriter(CAMINHO, true)){
			for(Funcionario f: funcionario) {
			fw.write(f.getNome() + ";" + f.getCargo() + ";" + f.getSalario() + "\n");
			}
		}catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void carregarArquivo() {
		try(BufferedReader br = new BufferedReader(new FileReader(CAMINHO))){
			String linha;
			
			while((linha = br.readLine()) != null) {
				String partes[] = linha.split(";");
				String nome = partes[0];
				Cargo cargo = Cargo.valueOf(partes[1]);
				double salario = Double.parseDouble(partes[2]);
				Funcionario f = new Funcionario(nome, cargo, salario);
				funcionario.add(f);
				cargos.computeIfAbsent(cargo, k -> new ArrayList<>()).add(f);
			}
		}catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
