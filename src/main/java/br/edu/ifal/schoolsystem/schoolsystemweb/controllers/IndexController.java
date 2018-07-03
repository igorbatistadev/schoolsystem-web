package br.edu.ifal.schoolsystem.schoolsystemweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Index")
public class IndexController {
	
	@RequestMapping(value="principal" ,method=RequestMethod.GET)
	public String adicionar(ModelMap model) {
		
		
		
		model.addAttribute("index");
		return "index/index";
	}

}
