package br.com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDespesas {
	
	//Lista de Despesas
	private ArrayList<Despesa> despesas = new ArrayList<Despesa>();
	
	//Lista de Totais por categoria
	private Map<Categoria, Double> totais = new HashMap<Categoria, Double>();
	
	//Adiciona uma Despesa
	public void adicionarDespesa(Despesa despesa) {
	 despesas.add(despesa);
	}
	
	//Listar as Despesas
	public void listarDespesa() {
	 for(Despesa d: despesas) {
		System.out.println("======================================");
		System.out.println("DESCRIÇÃO: " + d.getDescricao());
		System.out.println("CATEGORIA: " + d.getCategoria());
		System.out.println("VALOR: " + d.getValor());
		System.out.println("======================================");
	 }
	}
	
	//Total gasto por Categoria
	public void totalPorCategoria() {
	 for(Despesa d: despesas) {
		 double valorAtual = totais.getOrDefault(d.getCategoria(), 0.0);
		 totais.put(d.getCategoria(), valorAtual + 	d.getValor());
	 }
	 
	 for(Map.Entry<Categoria, Double> entry: totais.entrySet()) {
		 System.out.println(entry.getKey() + " -> " + entry.getValue());
	 }
	 
	}
	
	//Soma todos os valores das Despesas
	public double totalGeral() {
		double soma = 0;
		for(Despesa d: despesas) {
			soma += d.getValor();
		}
		return soma;
	}
}
