package br.com.Agendamento.Agendamento_Api.service;

import br.com.Agendamento.Agendamento_Api.model.Cliente;
import br.com.Agendamento.Agendamento_Api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente autalizarCliente(Long id, Cliente cliente){
        Cliente clienteExisting = clienteRepository.getReferenceById(id);
        clienteExisting.setNome(cliente.getNome());
        clienteExisting.setTelefone(cliente.getTelefone());
        return clienteRepository.save(clienteExisting);
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
