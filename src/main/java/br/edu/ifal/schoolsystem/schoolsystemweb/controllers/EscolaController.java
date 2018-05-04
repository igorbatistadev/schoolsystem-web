package br.edu.ifal.schoolsystem.schoolsystemweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.EscolaRepository;

@Controller
@RequestMapping
public class EscolaController {
	EscolaRepository escolaRepository;
	
}
