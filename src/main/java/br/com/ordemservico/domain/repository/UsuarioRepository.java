package br.com.ordemservico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordemservico.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Integer>{

}
