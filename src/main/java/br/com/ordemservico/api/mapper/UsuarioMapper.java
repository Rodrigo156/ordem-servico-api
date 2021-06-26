package br.com.ordemservico.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ordemservico.api.model.UsuarioDTO;
import br.com.ordemservico.domain.model.Usuario;

@Component
public class UsuarioMapper {

	@Autowired
	private ModelMapper mapper;
	
	
	public UsuarioDTO toModel(Usuario usuario) {
		return mapper.map(usuario , UsuarioDTO.class);
	}
	
	public Usuario toDomainObject(UsuarioDTO usuarioDTO) {
		return mapper.map(usuarioDTO, Usuario.class);
	}
	
}
