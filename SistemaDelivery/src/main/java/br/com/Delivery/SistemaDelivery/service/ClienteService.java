package br.com.Delivery.SistemaDelivery.service;

import br.com.Delivery.SistemaDelivery.model.Cliente;
import br.com.Delivery.SistemaDelivery.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente autalizarCliente(Long id, Cliente cliente){
        Cliente clienteExisting = clienteRepository.getReferenceById(id);
        clienteExisting.setNome(cliente.getNome());
        clienteExisting.setTelefone(cliente.getTelefone());
        clienteExisting.setEndereco(cliente.getEndereco());
        return clienteRepository.save(clienteExisting);
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
