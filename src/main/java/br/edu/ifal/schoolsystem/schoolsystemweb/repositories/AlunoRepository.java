package br.edu.ifal.schoolsystem.schoolsystemweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	public List<Aluno> findByNome(String nome);
}
