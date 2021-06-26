package br.com.ordemservico.domain.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordemservico.domain.model.Usuario;
import br.com.ordemservico.domain.repository.UsuarioRepository;
import br.com.ordemservico.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{
	
	private final UsuarioRepository usuarioRepository;
	

	@Override
	public Optional<Usuario> buscarUsuarioPorId(Integer id) {
		return usuarioRepository.findById(id);
	}

}
