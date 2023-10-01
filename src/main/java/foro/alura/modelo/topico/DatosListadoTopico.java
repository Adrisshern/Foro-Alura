package foro.alura.modelo.topico;


import java.time.LocalDate;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDate fecha_creacion, StatusTopico status_topico, Long usuarioId, Long cursoId) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus_topico(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}