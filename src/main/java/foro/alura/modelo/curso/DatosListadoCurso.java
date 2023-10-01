package foro.alura.modelo.curso;

public record DatosListadoCurso(Long id, String grupo, String categoria) {

    public DatosListadoCurso(Curso curso) {
        this(curso.getId(), curso.getGrupo(), curso.getCategoria());
    }
}
