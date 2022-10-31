package controller;

import java.io.IOException;
import java.util.Properties;

import javafx.collections.ObservableList;
import model.Afiliacion;
import model.ClubDeAmigos;
import model.Participante;
import persistencia.Persistencia;

public class SingletonController {

	
	private static SingletonController instancia = null;
	static ClubDeAmigos club = null;
	
	private SingletonController() {
		
		ClubDeAmigos club = new ClubDeAmigos();
		
	}
	
	
	
	
	// Get instance del patron de diseño Singleton
	public static SingletonController getInstance() {
		
		if (instancia == null) {
			instancia = new SingletonController();
		}
		return instancia;
	}
	
	public static ClubDeAmigos getClub() {
		
		if (club == null) {
			ClubDeAmigos club= new ClubDeAmigos();
		}
		return club;
	}
	
	//Añade una propieddad al archivo properties
	public static void agregarPropiedad (String nombre, String valor) {
		try {
			Persistencia.guardarPropiedades(nombre, valor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// devuelve un objeto properties cargado
	// desde el archivo
	public static Properties getPropiedades() {
		try {
			return Persistencia.getProperties();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// crea una afiliacion en la clase ClubDeAmigos
	public static Afiliacion crearAfiliacion(Participante amigo) {
		// añado el participante al club
		getClub().agregarParticipante(amigo);
		// Guardo el participante como TXT
		guardarParticipantesTXT(getClub().getListaDeParticipantes());
		// creo una afiliacion con un objeto amigo dentro de el
		Afiliacion afiliacion = new Afiliacion(amigo);
		// agrego la afiliacion a la clase principal
		getClub().agregarAfiliacion(afiliacion);
		// guardo la afiliacion como un TXT
		guardarAfiliacionTXT(getClub().getListaDeAfiliaciones());
		// retorno la afiliacion al controlador para que la añada a la lista
		return afiliacion;
	}

	// guarda un mnensaje en el log
	public static void guardarLog(String mensajeLog, int nivel, String accion) {
		Persistencia.guardaRegistroLog(mensajeLog, nivel, accion);
	}
	
	// guarda afiliacion como txt
	public static void guardarAfiliacionTXT(ObservableList<Afiliacion> lista) {
		try {
			Persistencia.guardarAfiliaciones(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// guarda participantes como txt
	public static void guardarParticipantesTXT(ObservableList<Participante> lista) {
		try {
			Persistencia.guardarAmigos(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void guardarAfilXML() {
		
	}
	
	// guarda el objeto como Binario
	public static void guardarAfilBinario() {
		
	}
	
	public static void cargarAfilXML() {
		
	}
	
	// guarda el objeto como Binario
	public static void cargarAfilBinario() {
		
	}
	
	// carga el objero como TXT
	public static void cargarObjetoTXT() {
		
	}
	
	// carga el objero como XML
	public static void cargarObjetoXML() {
		
	}
	
	// carga el objero como Binario
	public static void cargarObjetoBinario() {
		
	}


	public static void guardarXMLyBinario() {
		Persistencia.guardarClub(getClub());
		
	}
	
}
