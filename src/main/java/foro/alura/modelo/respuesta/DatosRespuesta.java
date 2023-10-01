package foro.alura.modelo.respuesta;

import java.time.LocalDate;

public record DatosRespuesta(Long id, LocalDate fecha_creacion, Boolean solucion) {
    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getFechaCreacion(), respuesta.getSolucion());
    }
}
