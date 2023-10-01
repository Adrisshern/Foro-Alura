package foro.alura.modelo.topico;

public record DatosTopico(Long id, String titulo, String mensaje, Long usuarioId, Long cursoId) {
    public DatosTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor().getId(), topico.getCurso().getId());
    }

}
