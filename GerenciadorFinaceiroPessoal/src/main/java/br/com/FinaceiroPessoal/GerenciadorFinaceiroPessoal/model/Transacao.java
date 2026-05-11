package br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.model;

import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.enums.CategoriasTransacoes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private double preco;

    @Enumerated(EnumType.STRING)
    private CategoriasTransacoes categoriasTransacoes;
}
