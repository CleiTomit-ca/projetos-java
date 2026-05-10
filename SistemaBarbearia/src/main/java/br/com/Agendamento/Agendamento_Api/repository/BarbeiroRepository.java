package br.com.Agendamento.Agendamento_Api.repository;

import br.com.Agendamento.Agendamento_Api.model.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
}
