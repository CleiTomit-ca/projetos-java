package br.com.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class GerenciadorProdutos {
	private List<Produto> produtos = new ArrayList<Produto>();
	private Map<CategoriaProdutos, List<Produto>> categoriasProdutos = new HashMap<CategoriaProdutos, List<Produto>>();
	final String CAMINHO = "/home/cleiton/Java_Backend/SistemaEstoqueProdutos/src/br/com/model/Produtos.txt";
	
	public void verificarEstoque() {
	    for(Produto p: produtos) {
	        if(p.getQuantidade() < 5) {
	            System.out.println("ALERTA: " + p.getNome() + " com apenas " + p.getQuantidade() + " unidades!");
	        }
	    }
	}
	
	public void cadastrarProdutos(String nome, CategoriaProdutos categoria, int quantidade, double price) throws QuantidadeInvalidaException {
		if(quantidade < 0) {
			throw new QuantidadeInvalidaException("Quantidade não pode ser negativa!");
		}
		Produto produto = new Produto(nome, categoria , quantidade, price);
		produtos.add(produto);
		categoriasProdutos.computeIfAbsent(categoria, k -> new ArrayList<>()).add(produto);
		System.out.println("Produtos Cadastrado!!!");
	}
	
	public void listarProdutos() {
		System.out.println("Listas de produtos: ");
		for(Produto p: produtos) {
			System.out.println("Nome: " + p.getNome());
			System.out.println("Categoria: " + p.getCategorias());
			System.out.println("Qtd: " + p.getQuantidade());
			System.out.println("Preço: " + p.getPrice());
			System.out.println("===============================");
		}
	}
	
	public void buscarPorCategoria(CategoriaProdutos categoria) {
		List<Produto> produtosCategorias = categoriasProdutos.get(categoria);
		
		if(produtosCategorias == null) {
			System.out.println("Nenhuma categoria adicionada!!!");
			return;
		}
		
		for(Produto p: produtosCategorias) {
			System.out.println("Categoria: " + p.getCategorias() + " -> " + p.getNome());
		}
		
	}
	
	public void salvarProdutos() {
		try(FileWriter fw = new FileWriter(CAMINHO, false)){
			for(Produto p: produtos) {
				fw.write(p.getNome() + ";" + p.getCategorias() + ";" + p.getQuantidade() + ";" + p.getPrice() + "\n");
			}
			System.out.println("Produto Salvo!!!");
		}catch (IOException e) {
			System.out.println("Erro ao salvar!!! " + e.getMessage());
		}
	}
	
	public void carregarProdutos() {
		produtos.clear(); 
	    categoriasProdutos.clear(); 
		try(BufferedReader br = new BufferedReader(new FileReader(CAMINHO))){
			String linha;
			
			while((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				String nome = partes[0];
				CategoriaProdutos categorias = CategoriaProdutos.valueOf(partes[1]);
				int quantidade = Integer.parseInt(partes[2]);
				double price = Double.parseDouble(partes[3]);
				Produto p = new Produto(nome, categorias, quantidade, price);
				produtos.add(p);
				categoriasProdutos.computeIfAbsent(categorias, k -> new ArrayList<>()).add(p);
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}
