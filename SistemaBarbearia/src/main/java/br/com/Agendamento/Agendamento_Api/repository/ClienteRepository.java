package br.com.Agendamento.Agendamento_Api.repository;

import br.com.Agendamento.Agendamento_Api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
