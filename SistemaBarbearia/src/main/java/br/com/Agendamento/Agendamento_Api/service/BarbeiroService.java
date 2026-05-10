package br.com.Agendamento.Agendamento_Api.service;

import br.com.Agendamento.Agendamento_Api.model.Barbeiro;
import br.com.Agendamento.Agendamento_Api.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    public List<Barbeiro> listaBarbeiros(){
        return barbeiroRepository.findAll();
    }

    public Barbeiro salvarBarbeiro(Barbeiro barbeiro){
        return barbeiroRepository.save(barbeiro);
    }

    public Barbeiro autalizarBarbeiro(Long id, Barbeiro barbeiro){
        Barbeiro barbeiroExisting = barbeiroRepository.getReferenceById(id);
        barbeiroExisting.setNome(barbeiro.getNome());
        barbeiroExisting.setEspecialidade(barbeiro.getEspecialidade());
        return barbeiroRepository.save(barbeiroExisting);
    }

    public void deletarBarbeiro(Long id){
        barbeiroRepository.deleteById(id);
    }
}
