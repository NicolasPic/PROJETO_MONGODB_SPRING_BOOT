package com.nicolas.wsmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AutorDTO autor;
	
	public ComentDTO() {
		
	}

	public ComentDTO(String text, Date date, AutorDTO autor) {
		super();
		this.text = text;
		this.date = date;
		this.autor = autor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
	
}
