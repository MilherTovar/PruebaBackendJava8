package tecnica.com.prueba.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tecnica.com.prueba.security.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario>findByEmail(String email);
}
