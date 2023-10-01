package foro.alura.controller;

import foro.alura.modelo.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public List<DatosUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        usuarioRepository.save(new Usuario(datosRegistroUsuario));
        return usuarioRepository.findAll().stream().map(DatosUsuario::new).toList();
    }

    @GetMapping
    public List<DatosListadoUsuario> listadoUsuarios() {
        return usuarioRepository.findAll().stream().map(DatosListadoUsuario::new).toList();
    }

    @PutMapping
    @Transactional
    public void actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatosUsuario(datosActualizarUsuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuarioRepository.delete(usuario);
    }
}
