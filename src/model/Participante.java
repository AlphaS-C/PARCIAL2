package model;

import java.io.Serializable;
import java.util.Objects;

public class Participante implements Serializable{

	private static final long serialVersionUID = 1L;
	String nombre;
	String apellidos;
	String cedula;
	String direccion;
	String categoria;
	
// constructor vacio
	public Participante() {
		
	}

	
	
public Participante(String nombre, String apellidos, String cedula, String direccion, String categoria) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.cedula = cedula;
	this.direccion = direccion;
	this.categoria = categoria;
}



// metodo toString
	@Override
	public String toString() {
		return nombre + "##" + apellidos + "##" + cedula + "##" + direccion + "##" + categoria + "##";
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
		Participante other = (Participante) obj;
		return Objects.equals(cedula, other.cedula);
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	
}
