package br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.repositoy;

import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
