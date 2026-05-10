package br.com.Delivery.SistemaDelivery.service;

import br.com.Delivery.SistemaDelivery.model.Produto;
import br.com.Delivery.SistemaDelivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }


    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }


    public Produto autalizarProduto( Long id, Produto produto){
        Produto produtoExisting = produtoRepository.getReferenceById(id);
        produtoExisting.setNome(produto.getNome());
        produtoExisting.setPreco(produto.getPreco());
        return produtoRepository.save(produtoExisting);
    }


    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
