package br.com.Produtos.api_produtos.dtos;

public record ProdutoResponseDto(
        Long id,
        String nome,
        double preco,
        int quantidade
) {
}
