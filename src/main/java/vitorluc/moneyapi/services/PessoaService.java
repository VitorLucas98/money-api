package vitorluc.moneyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vitorluc.moneyapi.entities.Pessoa;
import vitorluc.moneyapi.repositories.PessoaRepository;
import vitorluc.moneyapi.services.dtos.PessoaDTO;
import vitorluc.moneyapi.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll(){
        return repository.findAll().stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id){
        Pessoa pes = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Pessoa de id: "+ id +", não encontrada !"));
        return new PessoaDTO(pes);
    }

    @Transactional
    public PessoaDTO save(PessoaDTO dto){
        Pessoa pes = new Pessoa();
        pes.setId(dto.getId());
        pes.setNome(dto.getNome());
        pes.setAtivo(dto.isAtivo());
        pes.setNome(dto.getNome());
        pes.setEndereco(dto.getEndereco());
        pes = repository.save(pes);
        return new PessoaDTO(pes);
    }


    public void deletar(Long id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ObjectNotFoundException("Pessoa de id: "+ id +", não encontrada !");
        }
    }

}
