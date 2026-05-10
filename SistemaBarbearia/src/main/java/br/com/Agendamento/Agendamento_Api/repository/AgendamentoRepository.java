package br.com.Agendamento.Agendamento_Api.repository;

import br.com.Agendamento.Agendamento_Api.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
