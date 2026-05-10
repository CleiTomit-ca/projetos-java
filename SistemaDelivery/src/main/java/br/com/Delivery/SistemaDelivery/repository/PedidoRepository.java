package br.com.Delivery.SistemaDelivery.repository;

import br.com.Delivery.SistemaDelivery.model.Pedido;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
