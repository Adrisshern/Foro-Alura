package foro.alura.controller;

import foro.alura.modelo.respuesta.*;
import foro.alura.modelo.topico.Topico;
import foro.alura.modelo.topico.TopicoRepository;
import foro.alura.modelo.usuario.Usuario;
import foro.alura.modelo.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public List<DatosRespuesta> registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta) {
        Topico topico = topicoRepository.getReferenceById(datosRegistroRespuesta.topicoId());
        Usuario usuario = usuarioRepository.getReferenceById(datosRegistroRespuesta.usuarioId());
        Respuesta respuesta = new Respuesta(datosRegistroRespuesta, topico, usuario);
        respuestaRepository.save(respuesta);
        return respuestaRepository.findAll().stream().map(DatosRespuesta::new).toList();
    }

    @GetMapping
    public List<DatosListadoRespuesta> listadoRespuestas() {
        return respuestaRepository.findAll().stream().map(DatosListadoRespuesta::new).toList();
    }

    @PutMapping
    @Transactional
    public void actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta) {
        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
        respuesta.actualizarDatosR(datosActualizarRespuesta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuestaRepository.delete(respuesta);
    }
}
