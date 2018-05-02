package br.edu.ifal.schoolsystem.schoolsystemweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Professor;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	@Autowired
	ProfessorRepository professorRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Professor e = new Professor("pwebII");
		professorRepository.save(e);
		return "ok";
	
	}
	@RequestMapping(value="{id}/detalhes", method=RequestMethod.GET)
	public Professor buscar(@PathVariable("id")Integer id) {
		return professorRepository.getOne(id);
	}
	@RequestMapping(value="listar/todos", method=RequestMethod.GET)
	public List<Professor> listar() {
		return professorRepository.findAll();
	}
	@RequestMapping(value="pesquisar", method=RequestMethod.GET)
	public List<Professor> pesquisar(
		@RequestParam(name="nome", defaultValue="ALL")String nome){
		return professorRepository.findByNomeContaining(nome);
	}
}

