package com.nicolas.wsmongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.wsmongo.dto.UsuarioDTO;
import com.nicolas.wsmongo.entidades.Usuario;
import com.nicolas.wsmongo.repositorios.UsuarioRepositorio;
import com.nicolas.wsmongo.servicos.excecao.ObjetoNaoEncotradoExcecao;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repo;

	public List<Usuario> encotreTodos() {
		return repo.findAll();
	}

	public Usuario encontrePorId(String id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncotradoExcecao("Objeto não encontrado"));
	}

	public Usuario inserir(Usuario obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		encontrePorId(id);
		repo.deleteById(id);
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = encontrePorId(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}

	public Usuario doDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}
