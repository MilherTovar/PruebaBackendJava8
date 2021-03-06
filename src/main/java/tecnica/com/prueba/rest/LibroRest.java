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

import tecnica.com.prueba.modelo.Libro;
import tecnica.com.prueba.service.LibroService;

@RestController
@RequestMapping("/api/libro/")
public class LibroRest {

	@Autowired
	private LibroService libroService;
	
	@PostMapping
	private ResponseEntity<Libro> guardar(@RequestBody Libro libro){
		Libro temporal=libroService.create(libro);
		try {
			return ResponseEntity.created(new URI("/api/libro"+temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	private ResponseEntity<Optional<Libro>> listarLibroId(@RequestParam(value = "id") Long id){
		return ResponseEntity.ok(libroService.LibrofindById(id));
	}
	
	@GetMapping
	private ResponseEntity<List<Libro>> listarTodos(){
		return ResponseEntity.ok(libroService.getAllLibros());
	}
	
}
