package br.com.Delivery.SistemaDelivery.service;

import br.com.Delivery.SistemaDelivery.model.Pedido;
import br.com.Delivery.SistemaDelivery.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    public Pedido salvarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public Pedido autalizarPedido(Long id, Pedido pedido){
        Pedido pedidoExisting = pedidoRepository.getReferenceById(id);
        pedidoExisting.setCliente(pedido.getCliente());
        pedidoExisting.setItens(pedido.getItens());
        pedidoExisting.setStatus(pedido.getStatus());
        pedidoExisting.setDate(pedido.getDate());
        return pedidoRepository.save(pedidoExisting);
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }
}
