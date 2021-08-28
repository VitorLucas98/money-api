package vitorluc.moneyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vitorluc.moneyapi.entities.Categoria;
import vitorluc.moneyapi.repositories.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public List<Categoria> findALl(){
        return repository.findAll();
    }

}
