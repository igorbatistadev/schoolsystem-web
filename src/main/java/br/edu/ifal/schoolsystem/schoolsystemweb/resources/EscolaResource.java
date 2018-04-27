package br.edu.ifal.schoolsystem.schoolsystemweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Escola;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.EscolaRepository;

@RestController
@RequestMapping("/escola")
public class EscolaResource {

	@Autowired
	EscolaRepository escolaRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Escola e = new Escola("IFAL");
				
		escolaRepository.save(e);
		return "Ok";
	}
	
	@RequestMapping(value="{id}/detalhes", method=RequestMethod.GET)
	public Escola buscar(@PathVariable("id") Integer id) {
		return escolaRepository.getOne(id);
	}
	
	@RequestMapping(value="listar/todos", method=RequestMethod.GET)
	public List<Escola> listar(){
		return escolaRepository.findAll();
	}
	
	@RequestMapping(value="pesquisar", method=RequestMethod.GET)
	public List<Escola> pesquisar(
		@RequestParam(name="nome", defaultValue="ALL")String nome){
		System.out.println(nome);
		return escolaRepository.findByNomeContaining(nome);
	}
}
