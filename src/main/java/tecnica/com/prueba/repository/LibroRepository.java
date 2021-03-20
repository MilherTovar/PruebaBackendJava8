package tecnica.com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tecnica.com.prueba.modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
