package br.com.Produtos.api_produtos.execptions;

public record ErrorResponse(
        int status,
        String mensagem
) {
}
