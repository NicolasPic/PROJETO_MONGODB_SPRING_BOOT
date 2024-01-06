package com.nicolas.wsmongo.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.wsmongo.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{

}
