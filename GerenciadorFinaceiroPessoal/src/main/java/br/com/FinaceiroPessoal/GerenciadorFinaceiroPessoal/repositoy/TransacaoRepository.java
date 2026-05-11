package br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.repositoy;

import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
