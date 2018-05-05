package br.edu.ifal.schoolsystem.schoolsystemweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Aluno;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.AlunoRepository;

@Controller
@RequestMapping("/Aluno")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public String adicionar() {
		return "aluno/formAluno";
	}
	
	@RequestMapping(value="add" ,method=RequestMethod.POST)
	public String adicionar(Aluno aluno) {
		alunoRepository.save(aluno);
		return "redirect:/Aluno/add";
	}
	
	@RequestMapping(value="/deletar")
	public String deletar(Integer id) {
		alunoRepository.deleteById(id);
		return "redirect:/Aluno/listar";
	}
	
	@RequestMapping(value="/listar")
	public ModelAndView listaAlunos() {
		ModelAndView mv = new ModelAndView("aluno/tableAluno");
		Iterable<Aluno> alunos = alunoRepository.findAll();
		mv.addObject("alunos", alunos);
		return mv;
	}
}
