package tecnica.com.prueba.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tecnica.com.prueba.dto.Mensaje;
import tecnica.com.prueba.security.dto.NuevousuarioDto;
import tecnica.com.prueba.security.entity.Usuario;
import tecnica.com.prueba.security.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class authController {

    private final static Logger logger=LoggerFactory.getLogger(authController.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody NuevousuarioDto nuevousuarioDto){
        Usuario nuevousuario=new Usuario();
        nuevousuario.setNombreUsuario(nuevousuarioDto.getNombreUsuario());
        nuevousuario.setApellidoUsuario(nuevousuarioDto.getApellidoUsuario());
        nuevousuario.setEmail(nuevousuarioDto.getEmail());
        nuevousuario.setPassword(passwordEncoder.encode(nuevousuarioDto.getPassword()));
        nuevousuario.setEstado(true);
        usuarioService.nuevo(nuevousuario);
        return new ResponseEntity(new Mensaje("Funcionando"),HttpStatus.OK);
    }
}
