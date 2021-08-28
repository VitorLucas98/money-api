package vitorluc.moneyapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vitorluc.moneyapi.entities.Categoria;
import vitorluc.moneyapi.services.CategoriaService;
import vitorluc.moneyapi.services.dtos.CategoriaDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        return ResponseEntity.ok(service.findALl());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.save(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO dto, @PathVariable Long id){
        dto.setId(id);
        return ResponseEntity.ok(service.save(dto));
    }

}
