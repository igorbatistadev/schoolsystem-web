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

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Curso;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.CursoRepository;

@Controller
@RequestMapping("/Curso")
public class CursoController {
	@Autowired
	CursoRepository cursoRepository;


	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public String adicionar(ModelMap model) {	
		
		Curso curso = new Curso();
		
		model.addAttribute("curso", curso);
		
		return "curso/formCurso";
	}
	
	@RequestMapping(value="add" ,method=RequestMethod.POST)
	public String adicionar(@Valid Curso curso, BindingResult result) {
		cursoRepository.save(curso);
		return "redirect:/Curso/add";
	}
	
	@RequestMapping(value ="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") Integer id, ModelMap model) {
		Curso curso = cursoRepository.getOne(id);
		model.addAttribute("curso", curso);
		model.addAttribute("edit", true);
		
		return "curso/formCurso";
	}
	
	@RequestMapping(value="/deletar")
	public String deletar(Integer id) {
		cursoRepository.deleteById(id);
		return "redirect:/Curso/listar";
	}
	
	@RequestMapping(value="/listar")
	public ModelAndView listaCurso() {
		ModelAndView mv = new ModelAndView("curso/tableCurso");
		Iterable<Curso> curso = cursoRepository.findAll();
		mv.addObject("curso", curso);
		return mv;
	}
	
}
