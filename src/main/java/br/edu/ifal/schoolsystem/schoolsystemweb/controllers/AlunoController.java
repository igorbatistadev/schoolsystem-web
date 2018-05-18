package br.edu.ifal.schoolsystem.schoolsystemweb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Aluno;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.AlunoRepository;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.DisciplinaRepository;

@Controller
@RequestMapping("/Aluno")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public String adicionar(ModelMap model) {
		
		Aluno aluno = new Aluno();
		
		model.addAttribute("aluno", aluno);
		return "aluno/formAluno";
	}
	
	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public String adicionar(@Valid Aluno aluno, BindingResult result) {
		System.out.println(aluno);
		
		alunoRepository.save(aluno);
		return "redirect:/Aluno/add";
	}
	@RequestMapping(value ="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") Integer id, ModelMap model) {
		Aluno aluno = alunoRepository.getOne(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("edit", true);
		
		return "aluno/formAluno";
	}
	
	@RequestMapping(value="/deletar")
	public String deletar(@RequestParam("id") Integer id) {
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
