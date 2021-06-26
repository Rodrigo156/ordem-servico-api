package br.com.ordemservico.domain.service;

import java.util.Optional;

import br.com.ordemservico.domain.model.Usuario;

public interface UsuarioService {
	
	public Optional<Usuario> buscarUsuarioPorId(Integer id);

}
