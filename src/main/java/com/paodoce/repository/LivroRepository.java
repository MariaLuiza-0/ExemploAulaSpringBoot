package com.paodoce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paodoce.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
