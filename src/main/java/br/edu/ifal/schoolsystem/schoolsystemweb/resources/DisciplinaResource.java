package br.edu.ifal.schoolsystem.schoolsystemweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Disciplina;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.DisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Disciplina e = new Disciplina("pwebII");
		disciplinaRepository.save(e);
		return "ok";
	
	}
	@RequestMapping(value="{id}/detalhes", method=RequestMethod.GET)
	public Disciplina buscar(@PathVariable("id")Integer id) {
		return disciplinaRepository.getOne(id);
	}
	@RequestMapping(value="listar/todos", method=RequestMethod.GET)
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}
	@RequestMapping(value="pesquisar", method=RequestMethod.GET)
	public List<Disciplina> pesquisar(
		@RequestParam(name="nome", defaultValue="ALL")String nome){
		return disciplinaRepository.findByNomeContaining(nome);
	}
}






