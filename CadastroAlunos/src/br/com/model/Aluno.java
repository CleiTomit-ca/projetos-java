package br.com.model;

public class Aluno {
	private String nome;
	private double[] notas = new double[3];
	
	public Aluno(String nome, double[] notas) {
		this.nome = nome;
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}
	
	public double[] getNotas() {
		return notas;
	}
	
	public double mediaAluno(){
		double soma = 0;
		for(int i = 0; i < notas.length; i++) {
			soma += notas[i];			
		}
		return soma / notas.length;
	}
	
	public String situacaoAluno() {
		return (mediaAluno() >= 5)? "Aprovado" : "Reprovado";
	
	}
}

