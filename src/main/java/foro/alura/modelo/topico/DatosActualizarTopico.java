package foro.alura.modelo.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje, LocalDate fecha_creacion) {
}
