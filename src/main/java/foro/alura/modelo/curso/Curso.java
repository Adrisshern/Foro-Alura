package foro.alura.modelo.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
@Entity(name = "Curso")
@EqualsAndHashCode(of = "id")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String grupo;
	private String categoria;

	public Curso(DatosRegistroCurso datosRegistroCurso) {
		this.grupo = datosRegistroCurso.grupo();
		this.categoria = datosRegistroCurso.categoria();
	}
	public void actualizarDatosCurso(DatosActualizarCurso datosActualizarCurso) {
		if (datosActualizarCurso.grupo() != null) {
			this.grupo = datosActualizarCurso.grupo();
		}
		if (datosActualizarCurso.categoria() != null) {
			this.categoria = datosActualizarCurso.categoria();
		}
	}
}
