package br.edu.ifal.schoolsystem.schoolsystemweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Integer>{
	//@Query(value = "SELECT escola FROM Escola escola where escola.nome = ?1")
	public List<Escola> findByNome(String nome);
	public List<Escola> findByNomeIgnoreCase(String nome);
	public List<Escola> findByNomeContaining(String nome);
}
