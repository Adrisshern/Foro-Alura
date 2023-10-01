package foro.alura.modelo.curso;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(@NotNull Long id, String grupo, String categoria) {
}
