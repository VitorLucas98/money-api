package vitorluc.moneyapi.services.dtos;

import vitorluc.moneyapi.entities.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Long id;
    private String nome;

    public CategoriaDTO(){
    }

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(Categoria entity) {
        id = entity.getId();
        nome = entity.getNome();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
