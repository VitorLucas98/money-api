package vitorluc.moneyapi.services.dtos;

import vitorluc.moneyapi.entities.Endereco;
import vitorluc.moneyapi.entities.Pessoa;

import java.io.Serializable;


public class PessoaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Endereco endereco;
    private boolean ativo;

    public PessoaDTO(){
    }

    public PessoaDTO(Long id, String nome, Endereco endereco, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public PessoaDTO(Pessoa entity) {
        id = entity.getId();
        nome = entity.getNome();
        endereco = entity.getEndereco();
        ativo = entity.isAtivo();
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
