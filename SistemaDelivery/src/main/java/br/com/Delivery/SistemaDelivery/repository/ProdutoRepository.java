package br.com.Delivery.SistemaDelivery.repository;

import br.com.Delivery.SistemaDelivery.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
