package com.nicolas.wsmongo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nicolas.wsmongo.dto.AutorDTO;
import com.nicolas.wsmongo.dto.ComentDTO;

@Document
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private Date date;
	private String titulo;
	private String corpo;
	private AutorDTO usu;
	
	private List<ComentDTO> comentarios = new ArrayList<>();
	
	
	public Post() {
		
	}

	public Post(String id, Date date, String titulo, String corpo,AutorDTO usuario) {
		this.id = id;
		this.date = date;
		this.titulo = titulo;
		this.corpo = corpo;
		usu = usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public AutorDTO getUsu() {
		return usu;
	}

	public void setUsu(AutorDTO usu) {
		this.usu = usu;
	}
	
	
	public List<ComentDTO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentDTO> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}


	
	
}
