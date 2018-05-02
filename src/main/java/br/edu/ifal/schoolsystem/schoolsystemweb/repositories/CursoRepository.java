package br.edu.ifal.schoolsystem.schoolsystemweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	public Curso findByNome(String nome);
}
