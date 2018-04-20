package br.edu.ifal.schoolsystem.schoolsystemweb;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Curso;
import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Nota;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.CursoRepository;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.NotaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolsystemWebApplicationTests {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private NotaRepository notaRepository;
	
	@Test
	public void contextLoads() {
		
		Curso c =  new Curso(5,"Informática Básica");
		cursoRepository.save(c);
		
		Curso c1 = new Curso(6,"Adiministração");
		cursoRepository.save(c1);
		
		cursoRepository.findAll();
		
		cursoRepository.deleteById(5);
		cursoRepository.flush();
		
		List<Double> notas =  new ArrayList<>();
		notas.add(9.8);
		notas.add(9.2);
		notas.add(9.9);
		
		Nota n = new Nota();
		n.setNotas(notas);
		notaRepository.save(n);
	}

}
