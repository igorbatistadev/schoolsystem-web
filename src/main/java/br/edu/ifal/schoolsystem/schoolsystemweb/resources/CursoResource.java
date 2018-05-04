package br.edu.ifal.schoolsystem.schoolsystemweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Curso;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.CursoRepository;

@RestController
@RequestMapping("/api/curso")
public class CursoResource {

	@Autowired
	CursoRepository cursoRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Curso c = new Curso("Informática");
				
		cursoRepository.save(c);
		return "Ok";
	}
	
	@RequestMapping(value="detalhes/{id}", method=RequestMethod.GET)
	public Curso buscar(@PathVariable("id") Integer id) {
		return cursoRepository.getOne(id);
	}
	
	@RequestMapping(value="deletar/{id}", method=RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id) {
		cursoRepository.deleteById(id);
		return "Curso deletado com Sucesso";
	}
	
	@RequestMapping(value="/deletar/todos", method=RequestMethod.GET)
	public String deletarTodos() {
		cursoRepository.deleteAll();
		return "Todos os cursos foram deletados";
	}
	
	@RequestMapping(value="listar/todos", method=RequestMethod.GET)
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}
	
	@RequestMapping(value="atualizar/{id}", method=RequestMethod.GET)
	public String atualizar(@PathVariable("id") Integer id) {
		Curso c = cursoRepository.getOne(id);
		c.setNome("Informática para Internet");
		cursoRepository.saveAndFlush(c);
		return "Curso atualizado";
	}
	
	@RequestMapping(value="pesquisar", method=RequestMethod.GET)
	public Curso pesquisar(
		@RequestParam(name="nome", defaultValue="ALL")String nome){
		System.out.println(nome);
		return cursoRepository.findByNome(nome);
	}
}
