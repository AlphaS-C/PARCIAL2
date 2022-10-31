package model;

import java.io.Serializable;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClubDeAmigos implements Serializable{

	private static final long serialVersionUID = 1L;
	static ObservableList<Afiliacion> listaDeAfiliaciones = FXCollections.observableArrayList();
	static ObservableList<Participante> listaDeParticipantes = FXCollections.observableArrayList();
	
	
// constructor vacio
	public ClubDeAmigos() {
		
	}

	
	public static void agregarAfiliacion(Afiliacion afil) {
		
	listaDeAfiliaciones.add(afil);
	}

	public static void agregarParticipante(Participante part) {
		
	listaDeParticipantes.add(part);
		
	}
	
// metodo toString
	@Override
	public String toString() {
		return "Example [toString()=" + super.toString() + "]";
	}


	public static ObservableList<Afiliacion> getListaDeAfiliaciones() {
		return listaDeAfiliaciones;
	}


	public static void setListaDeAfiliaciones(ObservableList<Afiliacion> listaDeAfiliaciones) {
		ClubDeAmigos.listaDeAfiliaciones = listaDeAfiliaciones;
	}


	public static ObservableList<Participante> getListaDeParticipantes() {
		return listaDeParticipantes;
	}


	public static void setListaDeParticipantes(ObservableList<Participante> listaDeParticipantes) {
		ClubDeAmigos.listaDeParticipantes = listaDeParticipantes;
	}

	
	
//// metodo equals
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ClubDeAmigos other = (ClubDeAmigos) obj;
//		return Objects.equals(string, other.string);
//	}

	
	
}
