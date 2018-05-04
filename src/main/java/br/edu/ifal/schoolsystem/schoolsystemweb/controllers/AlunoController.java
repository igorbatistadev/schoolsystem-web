package br.edu.ifal.schoolsystem.schoolsystemweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.AlunoRepository;

@Controller
@RequestMapping("/Aluno")
public class AlunoController {
	AlunoRepository alunoRepository;
	
	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public String adicionar() {
		return "aluno/formAluno";
	}
}
