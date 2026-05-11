package br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.controller;

import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.model.Transacao;
import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<Transacao> listarTransacoes(){
        return transacaoService.listarTransacoes();
    }

    @PostMapping
    public Transacao salvarTransacao(@Valid @RequestBody Transacao transacao){
        return transacaoService.salvarTransacao(transacao);
    }

    @PutMapping("/{id}")
    public Transacao autalizarTransacao(@PathVariable Long id, @Valid @RequestBody Transacao transaco){
        return transacaoService.autalizarTransacao(id, transaco);
    }

    @DeleteMapping("/{id}")
    public void deletarTransacao(@PathVariable Long id){
        transacaoService.deletarTransacao(id);
    }
}
