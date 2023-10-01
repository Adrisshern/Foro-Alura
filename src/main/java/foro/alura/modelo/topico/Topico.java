package foro.alura.modelo.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import foro.alura.modelo.curso.Curso;
import foro.alura.modelo.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
    @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha_creacion = LocalDate.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status_topico;
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario autor;
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id")
	private Curso curso;

	public Topico(DatosRegistroTopico datosRegistroTopico, Usuario usuario, Curso curso) {
		this.titulo = datosRegistroTopico.titulo();
		this.mensaje = datosRegistroTopico.mensaje();
		this.fecha_creacion = datosRegistroTopico.fecha_creacion();
		this.status_topico = datosRegistroTopico.status_topico();
		this.autor = usuario;
		this.curso = curso;
	}

	public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
		if (datosActualizarTopico.titulo() != null) {
			this.titulo = datosActualizarTopico.titulo();
		}
		if (datosActualizarTopico.mensaje() != null) {
			this.mensaje = datosActualizarTopico.mensaje();
		}
		if (datosActualizarTopico.fecha_creacion() != null) {
			this.fecha_creacion = datosActualizarTopico.fecha_creacion();
		}
	}
}

