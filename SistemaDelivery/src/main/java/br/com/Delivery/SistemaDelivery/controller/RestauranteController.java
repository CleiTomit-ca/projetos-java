package br.com.Delivery.SistemaDelivery.controller;

import br.com.Delivery.SistemaDelivery.model.Restaurante;
import br.com.Delivery.SistemaDelivery.service.RestauranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> listarRestaurantes(){
        return restauranteService.listarRestaurantes();
    }

    @PostMapping
    public Restaurante salvarRestaurante(@Valid @RequestBody Restaurante restaurante){
        return restauranteService.salvar(restaurante);
    }

    @PutMapping("/{id}")
    public Restaurante atualizar(@PathVariable Long id, @Valid @RequestBody Restaurante restaurante){
        return restauranteService.autalizarRestaurante(id, restaurante);
    }

    @DeleteMapping("/{id}")
    public void deletarRestaurante(@PathVariable Long id){
        restauranteService.deletarRestaurante(id);
    }
}
