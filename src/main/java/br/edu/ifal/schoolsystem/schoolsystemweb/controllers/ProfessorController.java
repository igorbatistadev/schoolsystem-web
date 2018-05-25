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

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Professor;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.ProfessorRepository;

@Controller
@RequestMapping("/Professor")
public class ProfessorController {
	@Autowired
	ProfessorRepository professorRepository;
	
	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public String adicionar(ModelMap model) {
		
		Professor professor = new Professor();
		
		model.addAttribute("professor", professor);		
		return "professor/formProfessor";
	}
	
	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public String adicionar(@Valid Professor professor, BindingResult result) {
		System.out.println(professor);
		
		professorRepository.save(professor);
		return "redirect:/Professor/add";
	}
	
	@RequestMapping(value ="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") Integer id, ModelMap model) {
		Professor professor = professorRepository.getOne(id);
		model.addAttribute("professor", professor);
		model.addAttribute("edit", true);
		
		return "professor/formProfessor";
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
