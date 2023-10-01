package foro.alura.controller;


import foro.alura.modelo.curso.Curso;
import foro.alura.modelo.curso.CursoRepository;
import foro.alura.modelo.topico.*;
import foro.alura.modelo.usuario.Usuario;
import foro.alura.modelo.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public List<DatosTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {

        Usuario usuario = usuarioRepository.getReferenceById(datosRegistroTopico.usuarioId());
        Curso curso = cursoRepository.getReferenceById(datosRegistroTopico.cursoId());
        Topico topico = new Topico(datosRegistroTopico, usuario, curso);
        topicoRepository.save(topico);
        return topicoRepository.findAll().stream().map(DatosTopico::new).toList();
    }

    @GetMapping
    public List<DatosListadoTopico> listadoTopicos() {
        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

}
