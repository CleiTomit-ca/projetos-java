package br.com.Produtos.api_produtos.controller;

import br.com.Produtos.api_produtos.dtos.ProdutoCreateDto;
import br.com.Produtos.api_produtos.dtos.ProdutoResponseDto;
import br.com.Produtos.api_produtos.dtos.ProdutoUpdateDto;
import br.com.Produtos.api_produtos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public Page<ProdutoResponseDto> list(Pageable pageable){
        return service.listar(pageable);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> create(@Valid @RequestBody ProdutoCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> update(@PathVariable Long id, @Valid @RequestBody ProdutoUpdateDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/buscar")
    public List<ProdutoResponseDto> buscar(@RequestParam String nome){
        return service.buscarPorNome(nome);
    }
}
