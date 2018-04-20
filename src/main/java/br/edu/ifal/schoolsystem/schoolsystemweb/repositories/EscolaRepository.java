package br.edu.ifal.schoolsystem.schoolsystemweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Integer>{
	
}
