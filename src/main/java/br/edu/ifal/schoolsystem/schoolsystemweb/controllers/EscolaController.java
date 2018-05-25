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

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Escola;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.EscolaRepository;

@Controller
@RequestMapping("/Escola")
public class EscolaController {
	@Autowired
	EscolaRepository escolaRepository;
	
	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public String adicionar(ModelMap model) {
		
		Escola escola= new Escola();
		
		model.addAttribute("escola", escola);
		return "escola/formEscola";
	}
	
	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public String adicionar(@Valid Escola escola, BindingResult result) {
		escolaRepository.save(escola);
		return "redirect:/Escola/add";
	}
	
	@RequestMapping(value ="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") Integer id, ModelMap model) {
		Escola escola = escolaRepository.getOne(id);
		model.addAttribute("escola", escola);
		model.addAttribute("edit", true);
		
		return "escola/formEscola";
	}
	
	@RequestMapping(value="/deletar")
	public String deletar(Integer id) {
		escolaRepository.deleteById(id);
		return "redirect:/Escola/listar";
	}
	
	@RequestMapping(value="/listar")
	public ModelAndView listaEscola() {
		ModelAndView mv = new ModelAndView("escola/tableEscola");
		Iterable<Escola> escola = escolaRepository.findAll();
		mv.addObject("escola", escola);
		return mv;
	}
	
}
