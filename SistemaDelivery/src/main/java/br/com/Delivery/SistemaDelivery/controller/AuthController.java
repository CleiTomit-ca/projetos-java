package br.com.Delivery.SistemaDelivery.controller;

import br.com.Delivery.SistemaDelivery.model.Usuario;
import br.com.Delivery.SistemaDelivery.repository.UsuarioRepository;
import br.com.Delivery.SistemaDelivery.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    public String registro(@RequestBody Usuario usuario){
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuario.setRole("USER");
        usuarioRepository.save(usuario);
        return jwtService.gerarToken(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioExisting = usuarioRepository.findByEmail(usuario.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if(!new BCryptPasswordEncoder().matches(usuario.getPassword(), usuarioExisting.getPassword())){
            throw new RuntimeException("Senha inválida");
        }
        return jwtService.gerarToken(usuarioExisting);
    }

}
