package com.nicolas.wsmongo.dto;

import java.io.Serializable;

import com.nicolas.wsmongo.entidades.Usuario;

public class AutorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public AutorDTO() {
		
	}
	
	public AutorDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
