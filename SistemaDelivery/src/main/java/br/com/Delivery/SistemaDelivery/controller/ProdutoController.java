package br.com.Delivery.SistemaDelivery.controller;

import br.com.Delivery.SistemaDelivery.model.Produto;
import br.com.Delivery.SistemaDelivery.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @PostMapping
    public Produto salvarProduto(@Valid @RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto autalizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto){
        return produtoService.autalizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }

}
