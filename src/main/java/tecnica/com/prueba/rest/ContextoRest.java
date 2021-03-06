package tecnica.com.prueba.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tecnica.com.prueba.modelo.Contexto;
import tecnica.com.prueba.service.ContextoService;

@RestController
@RequestMapping("/api/contexto/")
public class ContextoRest {

	@Autowired
	private ContextoService contextoservice;
	
	@PostMapping
	private ResponseEntity<Contexto> guardar(@RequestBody Contexto contexto){
		Contexto temporal=contextoservice.create(contexto);
		try {
			return ResponseEntity.created(new URI("/api/contexto"+temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(value = "/contexto", method = RequestMethod.GET)
	private ResponseEntity<Optional<Contexto>> listarContextoId(@RequestParam(value = "id") Long id){
		return ResponseEntity.ok(contextoservice.contextoFindId(id));
	}
	
	@GetMapping
	private ResponseEntity<List<Contexto>> listarTodos(){
		return ResponseEntity.ok(contextoservice.getAllContextos());
	}
	
}
