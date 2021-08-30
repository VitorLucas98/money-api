package vitorluc.moneyapi.services.dtos;

import vitorluc.moneyapi.entities.Categoria;
import vitorluc.moneyapi.entities.Lancamento;
import vitorluc.moneyapi.entities.Pessoa;
import vitorluc.moneyapi.entities.enums.TipoLancamento;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

public class LancamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private Long valor;
    private String observacao;
    private TipoLancamento tipo;
    private Long idPessoa;
    private Long idCategoria;

    public LancamentoDTO(){
    }

    public LancamentoDTO(Long id, LocalDate dataVencimento, LocalDate dataPagamento, Long valor, String observacao, TipoLancamento tipo, Long idPessoa, Long idCategoria) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.observacao = observacao;
        this.tipo = tipo;
        this.idPessoa = idPessoa;
        this.idCategoria = idCategoria;
    }

    public LancamentoDTO(Lancamento entity) {
        id = entity.getId();
        dataVencimento = entity.getDataVencimento();
        dataPagamento = entity.getDataPagamento();
        valor = entity.getValor();
        observacao = entity.getObservacao();
        tipo = entity.getTipo();
        idPessoa = entity.getPessoa().getId();
        idCategoria = entity.getCategoria().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
