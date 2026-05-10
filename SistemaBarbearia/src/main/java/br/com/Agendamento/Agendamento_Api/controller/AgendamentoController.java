package br.com.Agendamento.Agendamento_Api.controller;

import br.com.Agendamento.Agendamento_Api.model.Agendamento;
import br.com.Agendamento.Agendamento_Api.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public List<Agendamento> listarAgendamentos(){return agendamentoService.listarAgendamentos();}

    @PostMapping
    public Agendamento salvarAgandamento(@Valid @RequestBody Agendamento agendamento){return agendamentoService.salvarAgendamento(agendamento);}

    @PutMapping("/{id}")
    public Agendamento autalizarAgendamento(@PathVariable Long id,@Valid @RequestBody Agendamento agendamento){return agendamentoService.autalizarAgendamento(id, agendamento);}

    @DeleteMapping("/{id}")
    public void deletarAgendamento(@PathVariable Long id){agendamentoService.deletarAgendamento(id);}
}
