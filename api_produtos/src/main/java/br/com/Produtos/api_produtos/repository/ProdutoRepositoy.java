package br.com.Produtos.api_produtos.repository;
import br.com.Produtos.api_produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepositoy extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);
}
