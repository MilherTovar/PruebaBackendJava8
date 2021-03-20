package tecnica.com.prueba.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tecnica.com.prueba.security.entity.Usuario;
import tecnica.com.prueba.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    Optional<Usuario>findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public void nuevo(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
