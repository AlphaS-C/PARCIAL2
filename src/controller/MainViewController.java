package controller;


import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Afiliacion;
import model.Participante;
import persistencia.Persistencia;


public class MainViewController implements Initializable {

	// Se crea un observable list, sirve para que  
	// se actualice la lista de la gui automaticamente
	ObservableList<Afiliacion> listaDeAfiliados = FXCollections.observableArrayList();
	// creo un archivo propiedades para cargarlo luego 
	// en el initialize
	Properties propiedades = new Properties();

 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Crea la instancia del singleton
	SingletonController control = SingletonController.getInstance();	
		// Setea las opciones del combo box
	combo.getItems().setAll("Amigos", "Trabajo", "Universidad");
		// Carga el archivo properties
	propiedades = SingletonController.getPropiedades();
	}
	
	 @FXML
	    private Button agregar;
	    @FXML
	    private TextField busqueda;

	    @FXML
	    private Button cargar;
	    
	    @FXML
	    private ComboBox combo;
		
	    @FXML
	    private Text feedback;

	    @FXML
	    private TextField field1;

	    @FXML
	    private TextField field2;

	    @FXML
	    private TextField field3;
	    
	    @FXML
	    private TextField field4;
	    
	    @FXML
	    private Button guardar;

	    @FXML
	    private ListView list;

	    
	    // crea la afiliacion con los valores
	    @FXML
	    void agregarObjeto() {
	    	if (field1.getText() != "" || field2.getText() != "" || field3.getText() != "" || field4.getText() != "") {
	    		// se crea un participante que see manda al singleton
	    		Participante part = new Participante(field1.getText(), field2.getText(), field3.getText(), field4.getText(), "" + combo.getValue());
	    		// guardo la categoria en un properties- uso como identificador la cedula
	    		// y como valor la categoria
	    		SingletonController.agregarPropiedad(field3.getText(), "" + combo.getValue());
	    		listaDeAfiliados.add(SingletonController.crearAfiliacion(part));
	    		addToList();
	    	} else System.out.println("Hay campos vacios");
	    	
	    }

	    @FXML
	    void buscar() {

	    }

	    @FXML
	    void cargar() {

	    }

	    @FXML
	    void guardar() {
	    	SingletonController.guardarXMLyBinario();
	    }

	    // funcion para añadir el ObservableList
	    // al Listview y que se actualice la informacion
	    // - Lo uso como "actualizdor" de la lista
	    private void addToList() {
	     list.setItems(listaDeAfiliados);
	    }
	
}
