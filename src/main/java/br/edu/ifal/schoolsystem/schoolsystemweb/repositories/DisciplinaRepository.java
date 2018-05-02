package br.edu.ifal.schoolsystem.schoolsystemweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>{
	
	public List<Disciplina> findByNome(String nome);
	public List<Disciplina> findByNomeIgnoreCase(String nome);
	public List<Disciplina> findByNomeContaining(String nome);

}


