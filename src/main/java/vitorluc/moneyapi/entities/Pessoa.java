package vitorluc.moneyapi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="tb_pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Pessoa(){
    }

    public Pessoa(Long id, String nome, Endereco endereco, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.ativo = ativo;
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