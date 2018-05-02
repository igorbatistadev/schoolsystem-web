package br.edu.ifal.schoolsystem.schoolsystemweb;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Professor;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.ProfessorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProfessorResourceTest {
	
	final String BASE_PATH = "http://localhost:8080/professor";
	
	@Autowired
	private ProfessorRepository repositorio;
	
	//usado para manipular o protocolo http
	private RestTemplate restTemplate;
	
	//responsável por converter uma String JSON em um objeto java
	private ObjectMapper MAPPER = new ObjectMapper();
	

	@Before
	public void setUp() {
		repositorio.deleteAll();
		
		repositorio.save(new Professor("informática","João"));
		repositorio.save(new Professor("redes","Maria"));
		repositorio.save(new Professor("matemática","Salah"));
		
		restTemplate = new RestTemplate();

	}
	
	@Test
	public void deveFuncionarAListagemDeTodosOsProfessores() throws JsonParseException, JsonMappingException, IOException {
		String resposta = restTemplate.getForObject(BASE_PATH + "/listar/todos",
				String.class);
	
		List<Professor> professores = MAPPER.readValue(resposta,MAPPER.getTypeFactory().
				constructCollectionLikeType(List.class, Professor.class));
		
		int tamanhoDaListaDeProfessoresEsperado = 3;
		assertEquals(tamanhoDaListaDeProfessoresEsperado, professores.size());
	
	}

}