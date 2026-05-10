package br.com.model;

import java.util.ArrayList;

public class SistemaAluno {
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	
	public void cadastrarAluno(String nome, double[] notas) {
		Aluno aluno = new Aluno(nome, notas);
		alunos.add(aluno);
		System.out.println("Aluno cadastrado com sucesso!");
	}
	
	public void listarAlunos() {
		for(Aluno lista: alunos) {
			System.out.println("Nome: " + lista.getNome().toUpperCase());
			System.out.println("Média: " + lista.mediaAluno());
			System.out.println(lista.situacaoAluno());
		}	
	}
	
	public void buscarAluno(String nome) {
			if(nome.isEmpty()) {
				System.out.println("Aluno não cadastrado!");
				return;
			}
	
			for(Aluno a: alunos) {
				if(nome.equals(a.getNome())) {
				System.out.println("Aluno encontrado: ");
				System.out.println("Nome: " + a.getNome().toUpperCase());
				System.out.println("Média: " + a.mediaAluno());
				System.out.println(a.situacaoAluno());
			}
		}
	}
}

