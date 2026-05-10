package br.com.model;

public class Funcionario {
	private String nome;
	private Cargo cargo;
	private double salario;
	
	public Funcionario(String nome, Cargo cargo, double salario){
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public double getSalario() {
		return salario;
	}
	
}