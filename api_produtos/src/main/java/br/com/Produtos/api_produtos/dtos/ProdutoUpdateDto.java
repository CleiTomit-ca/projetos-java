package br.com.Produtos.api_produtos.dtos;

public record ProdutoUpdateDto(
        Long id,
        String nome,
        double preco,
        int quantidade
) {
}
