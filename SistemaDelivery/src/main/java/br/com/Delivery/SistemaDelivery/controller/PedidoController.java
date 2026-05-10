package br.com.Delivery.SistemaDelivery.controller;

import br.com.Delivery.SistemaDelivery.model.Pedido;
import br.com.Delivery.SistemaDelivery.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido salvarPedido(@Valid @RequestBody Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido autalizarPedidos(@PathVariable Long id, @Valid @RequestBody Pedido pedido){
        Pedido pedidoExisting = pedidoRepository.getReferenceById(id);
        pedidoExisting.setCliente(pedido.getCliente());
        pedidoExisting.setItens(pedido.getItens());
        pedidoExisting.setStatus(pedido.getStatus());
        pedidoExisting.setDate(pedido.getDate());
        return pedidoRepository.save(pedidoExisting);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        pedidoRepository.deleteById(id);
    }
}
