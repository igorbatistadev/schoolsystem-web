package br.edu.ifal.schoolsystem.schoolsystemweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
