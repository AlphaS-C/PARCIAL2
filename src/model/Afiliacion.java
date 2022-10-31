package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Afiliacion implements Serializable{

	private static final long serialVersionUID = 1L;
	int codigo;
	LocalDate fecha;
	LocalDateTime hora;
	Participante amigo;
	
	
// constructor vacio
	public Afiliacion() {
		
	}
	// la fecha y la hora la guarda al momento de hacer
	// el objeto
	public Afiliacion(Participante amigo) {
		this.amigo = amigo;
		this.codigo = (int) (Math.random() * 1000);
		this.fecha = LocalDate.now();
		this.hora = LocalDateTime.now();
	}

// metodo toString
	@Override
	public String toString() {
		return codigo + "##" + fecha + "##" + hora.getHour() + ":" + hora.getMinute() + "##" + amigo.getNombre();
	}

// metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Afiliacion other = (Afiliacion) obj;
		return Objects.equals(codigo, other.codigo);
	}

	
	
}
