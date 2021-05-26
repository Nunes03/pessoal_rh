package br.com.lucasnunes.rh.repository;

import br.com.lucasnunes.rh.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {
}
