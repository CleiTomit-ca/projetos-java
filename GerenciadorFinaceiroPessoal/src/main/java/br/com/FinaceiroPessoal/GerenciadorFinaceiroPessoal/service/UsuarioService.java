package br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.service;

import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.model.Usuario;
import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.repositoy.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario autalizarUsuario(Long id, Usuario usuario){
        Usuario usuarioExisting = usuarioRepository.getReferenceById(id);
        usuarioExisting.setNome(usuario.getNome());
        usuarioExisting.setTelefone(usuario.getTelefone());
        return usuarioRepository.save(usuarioExisting);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
