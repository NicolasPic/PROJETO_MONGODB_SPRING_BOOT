package com.nicolas.wsmongo.servicos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.wsmongo.entidades.Post;
import com.nicolas.wsmongo.repositorios.PostRepositorio;
import com.nicolas.wsmongo.servicos.excecao.ObjetoNaoEncotradoExcecao;

@Service
public class PostServico {

	@Autowired
	private PostRepositorio repo;
	
	public Post encontrePorId(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncotradoExcecao("Objeto não encontrado"));
	}
	
	public List<Post> encontrePorTitulo(String text) {
		return repo.procurarTitulo(text);
	}
	
	public List<Post> pesquisaCompleta(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.procuraCompleta(text, minDate, maxDate);
	}
	
}
