package foro.alura.controller;

import foro.alura.modelo.curso.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public List<DatosCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        cursoRepository.save(new Curso(datosRegistroCurso));
        return cursoRepository.findAll().stream().map(DatosCurso::new).toList();
    }
    @GetMapping
    public List<DatosListadoCurso> listadoCurso() {
        return cursoRepository.findAll().stream().map(DatosListadoCurso::new).toList();
    }
    @PutMapping
    @Transactional
    public void actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso) {
        Curso curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatosCurso(datosActualizarCurso);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        cursoRepository.delete(curso);
    }
}
