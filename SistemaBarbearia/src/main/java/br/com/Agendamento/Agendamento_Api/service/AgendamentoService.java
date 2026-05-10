package br.com.Agendamento.Agendamento_Api.service;

import br.com.Agendamento.Agendamento_Api.model.Agendamento;
import br.com.Agendamento.Agendamento_Api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Agendamento> listarAgendamentos(){
        return agendamentoRepository.findAll();
    }

    public Agendamento salvarAgendamento(Agendamento agendamento){
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento autalizarAgendamento(Long id, Agendamento agendamento){
        Agendamento agendamentoExisting = agendamentoRepository.getReferenceById(id);
        agendamentoExisting.setCliente(agendamento.getCliente());
        agendamentoExisting.setBarbeiro(agendamento.getBarbeiro());
        agendamentoExisting.setHorario(agendamento.getHorario());
        agendamentoExisting.setData(agendamento.getData());
        return agendamentoRepository.save(agendamentoExisting);
    }

    public void deletarAgendamento(Long id){
        agendamentoRepository.deleteById(id);
    }
}
