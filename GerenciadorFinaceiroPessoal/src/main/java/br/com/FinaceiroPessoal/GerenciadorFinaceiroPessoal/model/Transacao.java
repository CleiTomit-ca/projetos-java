package br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.model;

import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.enums.CategoriasTransacoes;
import jakarta.persistence.*;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;

    @Enumerated(EnumType.STRING)
    private CategoriasTransacoes categoriasTransacoes;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriasTransacoes getCategoriasTransacoes() {
        return categoriasTransacoes;
    }

    public void setCategoriasTransacoes(CategoriasTransacoes categoriasTransacoes) {
        this.categoriasTransacoes = categoriasTransacoes;
    }
}
