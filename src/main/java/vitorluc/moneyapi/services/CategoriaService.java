package vitorluc.moneyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vitorluc.moneyapi.entities.Categoria;
import vitorluc.moneyapi.repositories.CategoriaRepository;
import vitorluc.moneyapi.services.dtos.CategoriaDTO;
import vitorluc.moneyapi.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public List<CategoriaDTO> findALl(){
        List<Categoria> cats = repository.findAll();
        return cats.stream().map( x -> new CategoriaDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoriaDTO findById(Long id){
        Categoria cat = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria de id: "+ id +", não encontrada !"));
        return new CategoriaDTO(cat);
    }



}
