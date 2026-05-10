package br.com.Agendamento.Agendamento_Api.controller;

import br.com.Agendamento.Agendamento_Api.model.Barbeiro;
import br.com.Agendamento.Agendamento_Api.service.BarbeiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @GetMapping()
    public List<Barbeiro> listarBarbeiros(){
        return barbeiroService.listaBarbeiros();
    }

    @PostMapping
    public Barbeiro salvarBarbeiro(@Valid @RequestBody Barbeiro barbeiro){return barbeiroService.salvarBarbeiro(barbeiro);}

    @PutMapping("/{id}")
    public Barbeiro autalizarBarbeiros(@PathVariable Long id,@Valid @RequestBody Barbeiro barbeiro){return barbeiroService.autalizarBarbeiro(id, barbeiro);}

    @DeleteMapping("/{id}")
    public void deletarBarbeiro(@PathVariable Long id){barbeiroService.deletarBarbeiro(id);}
}
