package br.edu.ifal.schoolsystem.schoolsystemweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
	public List<Professor> findByNome(String nome);
	public List<Professor> findByNomeIgnoreCase(String nome);
	public List<Professor> findByNomeContaining(String nome);
}
