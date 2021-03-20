package tecnica.com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tecnica.com.prueba.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
