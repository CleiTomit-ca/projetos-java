package br.com.Delivery.SistemaDelivery.service;

import br.com.Delivery.SistemaDelivery.model.Restaurante;
import br.com.Delivery.SistemaDelivery.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> listarRestaurantes(){
        return restauranteRepository.findAll();
    }

    public Restaurante salvar(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }

    public Restaurante autalizarRestaurante(Long id, Restaurante restaurante){
        Restaurante restauranteExisting = restauranteRepository.getReferenceById(id);
        restauranteExisting.setNome(restaurante.getNome());
        restauranteExisting.setCategoria(restaurante.getCategoria());
        return restauranteRepository.save(restauranteExisting);
    }

    public void deletarRestaurante(Long id){
        restauranteRepository.deleteById(id);
    }
}
