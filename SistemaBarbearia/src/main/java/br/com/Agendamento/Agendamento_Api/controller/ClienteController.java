package br.com.Agendamento.Agendamento_Api.controller;
import br.com.Agendamento.Agendamento_Api.model.Cliente;
import br.com.Agendamento.Agendamento_Api.service.ClienteService;
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
    public List<Cliente> listarClientes(){return clienteService.listarTodos();}

    @PostMapping
    public Cliente salvarCliente(@Valid @RequestBody Cliente cliente){return clienteService.salvarCliente(cliente);}

    @PutMapping("/{id}")
    public Cliente autalizarCliente( @PathVariable Long id, @Valid @RequestBody Cliente cliente){return clienteService.autalizarCliente(id, cliente);}

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){clienteService.deletarCliente(id);}
}