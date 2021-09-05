package vitorluc.moneyapi.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vitorluc.moneyapi.entities.Categoria;
import vitorluc.moneyapi.entities.Lancamento;
import vitorluc.moneyapi.entities.Pessoa;
import vitorluc.moneyapi.repositories.CategoriaRepository;
import vitorluc.moneyapi.repositories.LancamentoRepository;
import vitorluc.moneyapi.repositories.PessoaRepository;
import vitorluc.moneyapi.services.dtos.LancamentoDTO;
import vitorluc.moneyapi.services.exceptions.ObjectNotFoundException;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public Page<LancamentoDTO> findAllPaged(Pageable pageable, String observacao, String dataVencimentoInicial, String dataVencimentoFinal){
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateInicial = LocalDate.parse(dataVencimentoInicial,formatter);
        LocalDate dateFinal = LocalDate.parse(dataVencimentoFinal,formatter);
    	return repository.find(pageable, observacao, dateInicial, dateFinal).map(x -> new LancamentoDTO(x));
    }
    
    /*
    @Transactional(readOnly = true)
    public Page<LancamentoDTO> findAllPaged(Pageable pageable, String observacao){
    	return repository.find(pageable, observacao).map(x -> new LancamentoDTO(x));
    }
    */
    @Transactional(readOnly = true)
    public LancamentoDTO findById(Long id){
        return new LancamentoDTO(repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Lançamento de id = "+ id +", não existe !")));
    }

    @Transactional
    public LancamentoDTO save(LancamentoDTO dto){
        if (dto.getId() != null){
            Lancamento lan = repository.findById(dto.getId()).orElseThrow(
                    () -> new ObjectNotFoundException("Lançamento de id = "+ dto.getId() +", não existe !"));
        }
        Lancamento lancamento = new Lancamento();
        lancamento.setId(dto.getId());
        lancamento.setDataPagamento(dto.getDataPagamento());
        lancamento.setDataVencimento(dto.getDataVencimento());
        lancamento.setObservacao(dto.getObservacao());
        lancamento.setTipo(dto.getTipo());
        lancamento.setValor(dto.getValor());

        Categoria cat = categoriaRepository.findById(dto.getIdCategoria()).orElseThrow(
                () -> new ObjectNotFoundException("Categoria de id: " + dto.getIdCategoria()+ ", não encontrada !"));
        lancamento.setCategoria(cat);

        Pessoa pes = pessoaRepository.findById(dto.getIdPessoa()).orElseThrow(
                () -> new ObjectNotFoundException("Pessoa de id: " + dto.getIdPessoa()+ ", não encontrada !"));
        lancamento.setPessoa(pes);

        lancamento = repository.save(lancamento);
        return new LancamentoDTO(lancamento);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ObjectNotFoundException("Lançamento de id = "+ id +", não existe !");
        }
    }
}
