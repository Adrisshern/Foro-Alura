package foro.alura.modelo.respuesta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosActualizarRespuesta(@NotNull Long id, String mensaje, LocalDate fecha_creacion, Boolean solucion) {
}
