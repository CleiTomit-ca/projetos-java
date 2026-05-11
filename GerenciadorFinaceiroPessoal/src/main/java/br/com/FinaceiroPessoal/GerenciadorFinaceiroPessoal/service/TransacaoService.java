package br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.service;

import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.model.Transacao;
import br.com.FinaceiroPessoal.GerenciadorFinaceiroPessoal.repositoy.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> listarTransacoes(){
        return transacaoRepository.findAll();
    }

    public Transacao salvarTransacao(Transacao transacao){
        return transacaoRepository.save(transacao);
    }

    public Transacao autalizarTransacao(Long id, Transacao transacao){
        Transacao transacaoExisting = transacaoRepository.getReferenceById(id);
        transacaoExisting.setNome(transacao.getNome());
        transacaoExisting.setPreco(transacao.getPreco());
        transacaoExisting.setCategoriasTransacoes(transacao.getCategoriasTransacoes());
        return transacaoRepository.save(transacaoExisting);
    }

    public void deletarTransacao(Long id){
        transacaoRepository.deleteById(id);
    }
}
