package br.com.Produtos.api_produtos.dtos;

public record ProdutoCreateDto(
        String nome,
        double preco,
        int quantidade
) {
}
