package br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.controller;

import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.model.Usuario;
import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario salvar(@Valid @RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario autalizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuario){
        return usuarioService.autalizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
}
