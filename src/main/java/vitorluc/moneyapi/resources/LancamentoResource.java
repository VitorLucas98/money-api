package vitorluc.moneyapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vitorluc.moneyapi.services.LancamentoService;
import vitorluc.moneyapi.services.dtos.LancamentoDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoService service;

    @GetMapping
    public ResponseEntity<List<LancamentoDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

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
        return ResponseEntity.noContent().build();
    }
}

