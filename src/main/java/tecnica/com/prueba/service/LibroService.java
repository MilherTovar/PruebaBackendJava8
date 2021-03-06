package tecnica.com.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tecnica.com.prueba.modelo.Libro;
import tecnica.com.prueba.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository libroRepository;
	
	public Libro create (Libro libro) {
		return libroRepository.save(libro);
	}
	
	public List<Libro> getAllLibros(){
		return libroRepository.findAll();
	}
	
	public Optional<Libro>  LibrofindById(Long id){
		return libroRepository.findById(id);
	}
	
}
