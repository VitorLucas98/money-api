package vitorluc.moneyapi.resources;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vitorluc.moneyapi.services.LancamentoService;
import vitorluc.moneyapi.services.dtos.LancamentoDTO;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoService service;

    @GetMapping
    public ResponseEntity<Page<LancamentoDTO>> findAllPaged(@RequestParam(value = "observacao", defaultValue = "") String observacao,
                                                            @RequestParam(value = "dataVencimentoInicial", defaultValue = "")String dataVencimentoInicial,
                                                            @RequestParam(value = "dataVencimentoFinal", defaultValue = "")String dataVencimentoFinal,
                                                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                            @RequestParam(value = "size", defaultValue = "5") Integer size,
                                                            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                            @RequestParam(value = "orderBy", defaultValue = "dataVencimento") String orderBy){
        PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);

        return ResponseEntity.ok(service.findAllPaged(pageRequest, observacao, dataVencimentoInicial, dataVencimentoFinal));
    }
    /*
    @GetMapping
    public ResponseEntity<Page<LancamentoDTO>> findAllPaged(@RequestParam(value = "observacao", defaultValue = "") String observacao,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "5") Integer size,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "dataVencimento") String orderBy){
    	
PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
return ResponseEntity.ok(service.findAllPaged(pageRequest, observacao));
}
    */
    @GetMapping(value = "/{id}")
    public ResponseEntity<LancamentoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<LancamentoDTO> insert (@RequestBody LancamentoDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.save(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LancamentoDTO> update (@RequestBody LancamentoDTO dto, @PathVariable Long id){
        dto.setId(id);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    	service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

