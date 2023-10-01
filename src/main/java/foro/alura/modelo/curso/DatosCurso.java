package foro.alura.modelo.curso;

public record DatosCurso(Long id, String grupo, String categoria) {
    public DatosCurso(Curso curso) {
        this(curso.getId(), curso.getGrupo(), curso.getCategoria());
    }
}
