package com.nicolas.wsmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nicolas.wsmongo.dto.AutorDTO;
import com.nicolas.wsmongo.dto.ComentDTO;
import com.nicolas.wsmongo.entidades.Post;
import com.nicolas.wsmongo.entidades.Usuario;
import com.nicolas.wsmongo.repositorios.PostRepositorio;
import com.nicolas.wsmongo.repositorios.UsuarioRepositorio;

@Configuration
public class configuracao implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
	@Autowired
	private PostRepositorio postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepo.deleteAll();
		postRepo.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepo.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
		
		ComentDTO c1 = new ComentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDTO(alex));
		ComentDTO c2 = new ComentDTO("Aproveite", sdf.parse("22/03/2018"), new AutorDTO(bob));
		ComentDTO c3 = new ComentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDTO(alex));
		
		post1.getComentarios().addAll(Arrays.asList(c1, c2));
		post2.getComentarios().addAll(Arrays.asList(c3));
		
		postRepo.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		usuarioRepo.save(maria);
	}

}
