package br.com.model;

import java.util.ArrayList;

public class ContaBancaria {
	private String nome;
	private double saldo;
	private ArrayList<Movimentacao> extrato = new ArrayList<Movimentacao>();
	
	public ContaBancaria(String nome, double saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	
	public double depositar(double valor) {
		Movimentacao deposito = new Movimentacao("Deposito", valor);
		extrato.add(deposito);
		return saldo += valor;
	}
	
	public void sacar(double valor) {
		if(valor > saldo) {
			System.out.println("Saldo Insuficiente!");
			return;
		}
		if(valor > 1000) {
			System.out.println("Não pode sacar mais de que R$ 1000");
			return;
		}
		saldo -= valor;
		
		Movimentacao sacar = new Movimentacao("Saque", valor);
		extrato.add(sacar);
		System.out.println("Saque realizado com sucesso");
		
	}
	public void verExtrato() {
		for(Movimentacao movimentos: extrato) {
			System.out.println("Tipo: " + movimentos.getTipo());
			System.out.println("Valor: " + movimentos.getValor());
		}
	}
}
