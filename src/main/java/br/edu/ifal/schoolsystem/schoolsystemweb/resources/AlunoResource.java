package br.edu.ifal.schoolsystem.schoolsystemweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Aluno;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Aluno a = new Aluno("Igor");
				
		alunoRepository.save(a);
		return "Ok";
	}
	
	@RequestMapping(value="{id}/detalhes", method=RequestMethod.GET)
	public Aluno buscar(@PathVariable("id") Integer id) {
		return alunoRepository.getOne(id);
	}
	
	@RequestMapping(value="listar/todos", method=RequestMethod.GET)
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
	
	@RequestMapping(value="pesquisar", method=RequestMethod.GET)
	public List<Aluno> pesquisar(
		@RequestParam(name="nome", defaultValue="ALL")String nome){
		System.out.println(nome);
		return alunoRepository.findByNome(nome);
	}
	

}
