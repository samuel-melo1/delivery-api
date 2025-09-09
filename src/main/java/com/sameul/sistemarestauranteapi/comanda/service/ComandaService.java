package com.sameul.sistemarestauranteapi.comanda.service;

import com.sameul.sistemarestauranteapi.comanda.entity.Comanda;
import com.sameul.sistemarestauranteapi.comanda.repository.ComandaRepository;
import com.sameul.sistemarestauranteapi.comanda.request.ComandaRequest;
import org.springframework.stereotype.Service;

@Service
public class ComandaService {

    private final ComandaRepository repository;
    public ComandaService(ComandaRepository repository){
        this.repository = repository;
    }
    public void salvar(ComandaRequest request){
        try {
            Comanda novaComanda = new Comanda(request.getMesa());
            repository.save(novaComanda);
        }catch (Exception ex){
            throw new RuntimeException("Não foi possível salvar a comanda. Erro: " + ex.getMessage());
        }
    }
    public void fecharComanda(){

    }


}
