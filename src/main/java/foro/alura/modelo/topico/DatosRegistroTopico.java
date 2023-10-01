package foro.alura.modelo.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;



public record DatosRegistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Valid
        LocalDate fecha_creacion,
        @NotNull
        StatusTopico status_topico,
        @NotNull
        @Valid
        Long usuarioId,
        @NotNull
        @Valid
        Long cursoId) {

}
