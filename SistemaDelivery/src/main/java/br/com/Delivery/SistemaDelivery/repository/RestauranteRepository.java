package br.com.Delivery.SistemaDelivery.repository;

import br.com.Delivery.SistemaDelivery.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
