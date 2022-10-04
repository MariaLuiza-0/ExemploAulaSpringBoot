package com.paodoce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.paodoce.dto.LivroDTO;
import com.paodoce.entity.Livro;
import com.paodoce.form.LivroForm;
import com.paodoce.repository.LivroRepository;

@RestController
public class LivroController {
	
	/*@GetMapping("/hello")
	@ResponseBody
	public String hello() 
	{
		return "olá, mundo!";
	}*/
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/livro")
	public List<Livro> getAllLivros()  //List<Livro> retorna todos os livros cadastrados
	{
		return livroRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<LivroDTO> saveLivro(@RequestBody LivroForm form, UriComponentsBuilder builder)
	{
		//converter de LivroForm para LIvro
		Livro livro = form.converter();
		
		livroRepository.save(livro);
		
		UriComponents uriComponents = builder.path("/livro/{id}").buildAndExpand(livro.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(new LivroDTO(livro));
		
	}
	
}
