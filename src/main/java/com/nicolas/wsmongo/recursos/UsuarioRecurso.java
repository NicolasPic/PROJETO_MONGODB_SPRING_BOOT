package com.nicolas.wsmongo.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicolas.wsmongo.dto.UsuarioDTO;
import com.nicolas.wsmongo.entidades.Post;
import com.nicolas.wsmongo.entidades.Usuario;
import com.nicolas.wsmongo.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
 	public ResponseEntity<List<UsuarioDTO>> encontreTodos() {
		List<Usuario> list = servico.encotreTodos();
		List<UsuarioDTO> listDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> encontrePorId(@PathVariable String id) {
	    Usuario obj = servico.encontrePorId(id);
	    return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
	   servico.delete(id);
	    return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO objDto){
	    Usuario obj = servico.doDTO(objDto);
	    obj = servico.inserir(obj);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updade(@RequestBody UsuarioDTO objDto,@PathVariable String id){
	    Usuario obj = servico.doDTO(objDto);
	    obj.setId(id);
	    obj = servico.inserir(obj);
	    return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> encontrePost(@PathVariable String id) {
	    Usuario obj = servico.encontrePorId(id);
	    return ResponseEntity.ok().body(obj.getPosts());
	}
	
	
}
