package br.com.lucasnunes.rh.repository;

import br.com.lucasnunes.rh.model.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
