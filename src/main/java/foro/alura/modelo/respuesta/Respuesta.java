package foro.alura.modelo.respuesta;

import com.fasterxml.jackson.annotation.JsonFormat;
import foro.alura.modelo.topico.Topico;
import foro.alura.modelo.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topico_id")
	private Topico topico;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion = LocalDate.now();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario autor;
	private Boolean solucion = false;

	public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta, Topico topico, Usuario usuario) {
		this.mensaje = datosRegistroRespuesta.mensaje();
		this.topico = topico;
		this.fechaCreacion = datosRegistroRespuesta.fecha_creacion();
		this.autor = usuario;
		this.solucion = false;
	}

	public void actualizarDatosR(DatosActualizarRespuesta datosActualizarRespuesta) {
		if (datosActualizarRespuesta.mensaje() != null) {
			this.mensaje = datosActualizarRespuesta.mensaje();
		}
		if (datosActualizarRespuesta.fecha_creacion() != null) {
			this.fechaCreacion = datosActualizarRespuesta.fecha_creacion();
		}
		if (datosActualizarRespuesta.solucion() != null) {
			this.solucion = datosActualizarRespuesta.solucion();
		}
	}
}

