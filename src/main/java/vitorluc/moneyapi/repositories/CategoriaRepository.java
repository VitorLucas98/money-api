package vitorluc.moneyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitorluc.moneyapi.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
