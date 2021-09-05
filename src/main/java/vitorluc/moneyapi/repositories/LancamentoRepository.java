package vitorluc.moneyapi.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vitorluc.moneyapi.entities.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
		
	@Query("SELECT obj FROM Lancamento obj WHERE "
			+ "(LOWER(obj.observacao) LIKE LOWER(CONCAT('%',:observacao, '%'))) OR "
			+ "obj.dataVencimento BETWEEN :dataVencimentoInicial AND :dataVencimentoFinal")
	Page<Lancamento> find(Pageable pageable,String observacao, LocalDate dataVencimentoInicial, LocalDate dataVencimentoFinal);

	/*
	@Query("SELECT obj FROM Lancamento obj WHERE "
			+ "(LOWER(obj.observacao) LIKE LOWER(CONCAT('%',:observacao, '%')))")
	Page<Lancamento> find(Pageable pageable,String observacao);
	*/
}
