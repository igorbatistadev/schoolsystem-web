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

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Disciplina;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.DisciplinaRepository;

@Controller
@RequestMapping("/Disciplina")
public class DisciplinaController {
	@Autowired
	DisciplinaRepository disciplinarepository;
	
	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public String adicionar(ModelMap model) {
			
		Disciplina disciplina = new Disciplina();
		
		model.addAttribute("disciplina", disciplina);
		
		return "disciplina/formDisciplina";
	}
	
	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public String adicionar(@Valid Disciplina disciplina, BindingResult result) {
		disciplinarepository.save(disciplina);
		return "redirect:/Disciplina/add";
	}
	
	@RequestMapping(value ="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") Integer id, ModelMap model) {
		Disciplina disciplina = disciplinarepository.getOne(id);
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("edit", true);
		
		return "disciplina/formDisciplina";
	}
	
	@RequestMapping(value="/deletar")
	public String deletar(Integer id) {
		disciplinarepository.deleteById(id);
		return "redirect:/Disciplina/listar";
	}
	
	@RequestMapping(value="/listar")
	public ModelAndView listaDisciplina() {
		ModelAndView mv = new ModelAndView("disciplina/tableDisciplina");
		Iterable<Disciplina> disciplina = disciplinarepository.findAll();
		mv.addObject("disciplina", disciplina);
		return mv;
	}
}
