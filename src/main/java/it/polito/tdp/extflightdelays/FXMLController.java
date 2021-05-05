/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.ResourceBundle;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.extflightdelays.model.Airport;
import it.polito.tdp.extflightdelays.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="distanzaMinima"
    private TextField distanzaMinima; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizza"
    private Button btnAnalizza; // Value injected by FXMLLoader

    @FXML
    void doAnalizzaAeroporti(ActionEvent event) {
    	int distanza;
    	txtResult.clear();
    	try {
    		distanza = Integer.parseInt(distanzaMinima.getText());
    		Graph<Airport, DefaultWeightedEdge> grafo = model.creaGrafo(distanza);
    		txtResult.appendText("Il grafo è stato creato con "+grafo.vertexSet().size() +  " vertici e " + grafo.edgeSet().size() + " archi");
    		txtResult.appendText("\n\nELENCO ROTTE:\n");
    		String stampa = "";
    		for(DefaultWeightedEdge e: grafo.edgeSet()) {
    			stampa += grafo.getEdgeSource(e).toString()+ "\t-\t";
    			stampa += grafo.getEdgeTarget(e).toString() + ": " + grafo.getEdgeWeight(e) +"\n";
    		}
    		txtResult.appendText(stampa);
    	}catch(NumberFormatException nfe) {
    		txtResult.appendText("Numero inserito non valido!");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert distanzaMinima != null : "fx:id=\"distanzaMinima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
