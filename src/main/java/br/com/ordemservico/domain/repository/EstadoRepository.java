package br.com.ordemservico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordemservico.domain.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
