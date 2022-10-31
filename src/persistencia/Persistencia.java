package persistencia;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Afiliacion;
import model.ClubDeAmigos;
import model.Participante;


public class Persistencia {

	public static final String RUTA_ARCHIVO_AFILIACIONES = "src/resources/afiliaciones.txt";
	public static final String RUTA_ARCHIVO_CLUB_XML = "src/resources/club.xml";
	public static final String RUTA_ARCHIVO_AMIGOS = "src/resources/amigos.txt";
	public static final String RUTA_ARCHIVO_AMIGOS_XML = "src/resources/amigos.xml";
	public static final String RUTA_ARCHIVO_AMIGOS_BIN = "src/resources/amigos.bin";
	public static final String RUTA_ARCHIVO_LOG = "src/persistencia/log.txt";
	public static final String RUTA_ARCHIVO_PROPERTIES = "src/persistencia/properties.properties";

	public static Properties getProperties() throws IOException {
		FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(RUTA_ARCHIVO_PROPERTIES);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
		return prop;
	}
	
	public static void guardarPropiedades(String nombre, String valor) throws IOException {
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        try {
            Properties configProperty = new Properties();

            File file = new File(RUTA_ARCHIVO_PROPERTIES);
            fileIn = new FileInputStream(file);
            configProperty.load(fileIn);
            configProperty.setProperty(nombre, valor);
            fileOut = new FileOutputStream(file);
            configProperty.store(fileOut, "null");

        } catch (Exception ex) {
           ex.printStackTrace();
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	

	//  GUARDAR OBSERVABLE LIST 

	public static void guardarClub(ClubDeAmigos club) {
	try {
		ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_CLUB_XML, club);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	//  GUARDAR OBSERVABLE LIST 
	
	// GUARDA LA LISTA COMO ARRAYLIST PORQUE UNA OBSERVABLE LIST NO ES SERIALIZABLE
//	public static void guardarProgramas(ObservableList<Programa> lista) {
//	try {
//		List<Programa> list = lista.stream().collect(Collectors.toList());
//		ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_PROGRAMAS, list);
//		
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}

	// CARGR OBSERVABLE LIST
	
//	public static ObservableList<Programa> cargarProgramasXML() {
//		
//		ObservableList<Programa> lista = FXCollections.observableArrayList();
//		List<Programa> list = null;
//		try {
//			list = (List<Programa>)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_PROGRAMAS);
//			lista.addAll(list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//	}
	
	
	
	


	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	
	
	// GUARDA AFILIACIONES COMO TXT
	
	public static void guardarAfiliaciones(ObservableList<Afiliacion> listaAfiliaciones) throws IOException {
		// TODO Auto-generated method stub
		String contenido = "";
		
		for(Afiliacion afil:listaAfiliaciones) 
		{
			System.out.println(afil.toString());
			contenido+= afil.toString() + "\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_AFILIACIONES, contenido, false);
		
	}
	
	
	// GUARDA AFILIACIONES COMO TXT
	
	public static void guardarAmigos(ObservableList<Participante> listaPart) throws IOException {
		// TODO Auto-generated method stub
		String contenido = "";
		
		for(Participante part:listaPart) 
		{
			System.out.println(part.toString());
			contenido+= part.toString() + "\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_AMIGOS, contenido, false);
		
	}
	
	// FUNCION PARA GUARDAR COMO TXT !!!
	
//	public static void guardarClientes(ArrayList<Cliente> listaClientes) throws IOException {
//		// TODO Auto-generated method stub
//		String contenido = "";
//		
//		for(Cliente cliente:listaClientes) 
//		{
//			contenido+= cliente.getNombre()+","+cliente.getApellido()+","+cliente.getCedula()+","+cliente.getDireccion()
//		     +","+cliente.getCorreo()+","+cliente.getFechaNacimiento()+","+cliente.getTelefono()+"\n";
//		}
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
//		
//	}
	

	
	
	
//	----------------------LOADS------------------------
	
	/**
	 * 
	 * @param tipoPersona
	 * @param ruta
	 * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	// FUNCION PARA CARGAR COMO TXT !!!!!

//	public static ObservableList<Cliente> cargarAfil() throws FileNotFoundException, IOException 
//	{
//		ArrayList<Cliente> clientes =new ArrayList<Cliente>();
//		
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
//		String linea="";
//		
//		for (int i = 0; i < contenido.size(); i++)
//		{
//			linea = contenido.get(i);
//			Cliente cliente = new Cliente();
//			cliente.setNombre(linea.split(",")[0]);
//			cliente.setApellido(linea.split(",")[1]);
//			cliente.setCedula(linea.split(",")[2]);
//			cliente.setDireccion(linea.split(",")[3]);
//			cliente.setCorreo(linea.split(",")[4]);
//			cliente.setFechaNacimiento(linea.split(",")[5]);
//			cliente.setTelefono(linea.split(",")[6]);
//			clientes.add(cliente);
//		}
//		return clientes;
//	}
	
	
//	public static ArrayList<Cliente> cargarClientes() throws FileNotFoundException, IOException 
//	{
//		ArrayList<Cliente> clientes =new ArrayList<Cliente>();
//		
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
//		String linea="";
//		
//		for (int i = 0; i < contenido.size(); i++)
//		{
//			linea = contenido.get(i);
//			Cliente cliente = new Cliente();
//			cliente.setNombre(linea.split(",")[0]);
//			cliente.setApellido(linea.split(",")[1]);
//			cliente.setCedula(linea.split(",")[2]);
//			cliente.setDireccion(linea.split(",")[3]);
//			cliente.setCorreo(linea.split(",")[4]);
//			cliente.setFechaNacimiento(linea.split(",")[5]);
//			cliente.setTelefono(linea.split(",")[6]);
//			clientes.add(cliente);
//		}
//		return clientes;
//	}
	
	
	
//	private static ArrayList<Empleado> cargarEmpleados() throws IOException {
//		
//		ArrayList<Empleado> empleados =new ArrayList<Empleado>();
//		
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
//		String linea="";
//		
//		for (int i = 0; i < contenido.size(); i++)
//		{
//			linea = contenido.get(i);
//			Empleado empleado = new Empleado();
//			empleado.setNombre(linea.split(",")[0]);
//			empleado.setApellido(linea.split(",")[1]);
//			empleado.setCedula(linea.split(",")[2]);
//			empleado.setFechaNacimiento(linea.split(",")[3]);
//			empleados.add(empleado);
//		}
//		return empleados;
//	}
	
	


	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
	{
		
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}


//	public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioExcepcion {
//		
//		if(validarUsuario(usuario,contrasenia)) {
//			return true;
//		}else {
//			throw new UsuarioExcepcion("Usuario no existe");
//		}
//		
//	}
	
//	private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException 
//	{
//		ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);
//		
//		for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++) 
//		{
//			Usuario usuarioAux = usuarios.get(indiceUsuario);
//			if(usuarioAux.getUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
//				return true;
//			}
//		}
//		return false;
//	}

//	public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
//		ArrayList<Usuario> usuarios =new ArrayList<Usuario>();
//		
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
//		String linea="";
//		
//		for (int i = 0; i < contenido.size(); i++) {
//			linea = contenido.get(i);
//			
//			Usuario usuario = new Usuario();
//			usuario.setUsuario(linea.split(",")[0]);
//			usuario.setContrasenia(linea.split(",")[1]);
//			
//			usuarios.add(usuario);
//		}
//		return usuarios;
//	}
	
	
//	----------------------SAVES------------------------
	
	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	

	
	
//	public static void guardarObjetos(ArrayList<Cliente> listaClientes, String ruta) throws IOException  {
//		String contenido = "";
//		
//		for(Cliente clienteAux:listaClientes) {
//			contenido+= clienteAux.getNombre()+","+clienteAux.getApellido()+","+clienteAux.getCedula()+clienteAux.getDireccion()
//					     +","+clienteAux.getCorreo()+","+clienteAux.getFechaNacimiento()+","+clienteAux.getTelefono()+"\n";
//		}
//		ArchivoUtil.guardarArchivo(ruta, contenido, true);
//	}


	
	
	
	//------------------------------------SERIALIZACIÓN  y XML
	
	
	
	// FUNCION PARA CARGAR EN BINARIO
	
//	public static Banco cargarRecursoBancoBinario() {
//		
//		Banco banco = null;
//		
//		try {
//			banco = (Banco)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return banco;
//	}
	
	// FUNCION PARA GUARDAR EN BINARIO
	
//	public static void guardarRecursoBancoBinario(Banco banco) {
//		
//		try {
//			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO, banco);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	// FUNCCION PARA CARGAR EN XML
	
//	public static Banco cargarRecursoBancoXML() {
//		
//		Banco banco = null;
//		
//		try {
//			banco = (Banco)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return banco;
//
//	}

	// FUNCION PARA GUARDAR COMO XML
	
//	public static void guardarRecursoBancoXML(Banco banco) {
//		
//		try {
//			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML, banco);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}