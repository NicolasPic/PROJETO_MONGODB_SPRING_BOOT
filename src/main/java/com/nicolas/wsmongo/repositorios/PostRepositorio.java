package com.nicolas.wsmongo.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nicolas.wsmongo.entidades.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String>{


	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> procurarTitulo(String text);
	
	List<Post> findByTituloContainingIgnoreCase(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentarios.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> procuraCompleta(String text, Date minDate, Date maxDate);
}
