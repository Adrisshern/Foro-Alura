package foro.alura.modelo.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        @NotBlank
        String grupo,
        @NotBlank
        String categoria) {
}
