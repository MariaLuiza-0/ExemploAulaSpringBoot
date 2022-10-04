package com.paodoce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //tudo que for mecher com banco precisa swer entidade
public class Livro {
	
	@Id //chave_primaria 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_incremento 
	private Long id;
	private String nome;
	private String editora;
	private String autores;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	
	
}
