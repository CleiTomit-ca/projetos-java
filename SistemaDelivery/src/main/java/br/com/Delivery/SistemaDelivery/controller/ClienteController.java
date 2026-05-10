package br.com.Delivery.SistemaDelivery.controller;

import br.com.Delivery.SistemaDelivery.model.Cliente;
import br.com.Delivery.SistemaDelivery.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente salvarCliente(@Valid @RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente autalizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        return clienteService.autalizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }
}
