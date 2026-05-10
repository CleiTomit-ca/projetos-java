package br.com.Delivery.SistemaDelivery.repository;

import br.com.Delivery.SistemaDelivery.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}