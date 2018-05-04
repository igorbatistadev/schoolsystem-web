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
@RequestMapping("/api/disciplina")
public class DisciplinaResource {
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Disciplina e = new Disciplina("pwebII");
		disciplinaRepository.save(e);
		return "ok";
	}
	
	@RequestMapping(value="detalhes/{id}", method=RequestMethod.GET)
	public Disciplina buscar(@PathVariable("id")Integer id) {
		return disciplinaRepository.getOne(id);
	}
	
	@RequestMapping(value="deletar/{id}", method=RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id) {
		disciplinaRepository.deleteById(id);
		return "Disciplina deletada com Sucesso";
	}
	
	@RequestMapping(value="/deletar/todos", method=RequestMethod.GET)
	public String deletarTodos() {
		disciplinaRepository.deleteAll();
		return "Todas as Disciplinas foram deletados";
	}
	
	@RequestMapping(value="listar/todos", method=RequestMethod.GET)
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}
	
	@RequestMapping(value="atualizar/{id}", method=RequestMethod.GET)
	public String atualizar(@PathVariable("id") Integer id) {
		Disciplina d = disciplinaRepository.getOne(id);
		d.setNome("Programação Web II");
		disciplinaRepository.saveAndFlush(d);
		return "Curso atualizado";
	}
	
	@RequestMapping(value="pesquisar", method=RequestMethod.GET)
	public List<Disciplina> pesquisar(
		@RequestParam(name="nome", defaultValue="ALL")String nome){
		return disciplinaRepository.findByNomeContaining(nome);
	}
}






