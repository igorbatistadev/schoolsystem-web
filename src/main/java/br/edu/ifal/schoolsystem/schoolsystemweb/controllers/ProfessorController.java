package br.edu.ifal.schoolsystem.schoolsystemweb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Professor;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.ProfessorRepository;

@Controller
@RequestMapping("/Professor")
public class ProfessorController {
	@Autowired
	ProfessorRepository professorRepository;
	
	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public String adicionar(ModelMap model) {
		
		
		return "professor/formProfessor";
	}
	
	@RequestMapping(value="add" ,method=RequestMethod.POST)
	public String adicionar(@Valid Professor professor, BindingResult result) {
		professorRepository.save(professor);
		return "redirect:/Professor/add";
	}
	
	@RequestMapping(value="/deletar")
	public String deletar(Integer id) {
		professorRepository.deleteById(id);
		return "redirect:/Professor/listar";
	}
	
	@RequestMapping(value="/listar")
	public ModelAndView listaProfessor() {
		ModelAndView mv = new ModelAndView("professor/tableProfessor");
		Iterable<Professor> professor = professorRepository.findAll();
		mv.addObject("professor", professor);
		return mv;
	}
	
}
