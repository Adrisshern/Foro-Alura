package foro.alura.modelo.respuesta;

import java.time.LocalDate;

public record DatosListadoRespuesta(Long id, String mensaje, Long topicoId, LocalDate fecha_creacion, Long usuarioId, Boolean solucion) {
    public DatosListadoRespuesta(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getTopico().getId(), respuesta.getFechaCreacion(),respuesta.getAutor().getId(), respuesta.getSolucion());
    }
}
