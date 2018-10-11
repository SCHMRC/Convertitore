/**
 * Sample Skeleton for 'Convertitore.fxml' Controller Class
 */

package convertitore;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConvertitoreController {
	
	private Model model;
	
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    
    @FXML // fx:id="btnSave"
    private Button btnSave; // Value injected by FXMLLoader

    @FXML // fx:id="btnSave2"
    private Button btnSave2; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtFactor2"
    private TextField txtFactor2; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtFactor1"
    private TextField txtFactor1; // Value injected by FXMLLoader

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtEuro"
    private TextField txtEuro; // Value injected by FXMLLoader

    @FXML // fx:id="txtDollari"
    private TextField txtDollari; // Value injected by FXMLLoader

    @FXML // fx:id="btnDollari"
    private Button btnDollari; // Value injected by FXMLLoader

    @FXML // fx:id="txtConvEuro"
    private TextField txtConvEuro; // Value injected by FXMLLoader

    @FXML // fx:id="txtConvDollari"
    private TextField txtConvDollari; // Value injected by FXMLLoader

    @FXML // fx:id="btnEuro"
    private Button btnEuro; // Value injected by FXMLLoader

    @FXML
    void saveE(ActionEvent event) throws IOException {  	
    	model.setEuro(Double.parseDouble(txtFactor1.getText()));
    	model.scrivi(txtFactor1.getText());

    }
    
    @FXML
    void saveD(ActionEvent event) throws IOException {
    	model.setDollaro(Double.parseDouble(txtFactor2.getText()));
    	model.scrivi(txtFactor2.getText());

    }

    @FXML
    void handleDollari(ActionEvent event) {
    	try {
    	Number x = Integer.parseInt(txtEuro.getText())*model.getEuro();
    	txtConvDollari.setText(x.toString()+"$");}catch(NumberFormatException exc) {
    		txtConvDollari.setText("Inserisci un numero e non una lettera");
    	}

    }

    @FXML
    void handleEuro(ActionEvent event) {
    	try {
    	Number x = Integer.parseInt(txtDollari.getText())*model.getDollaro();
    	txtConvEuro.setText(x.toString()+"€");}catch(NumberFormatException exc) {
    		txtConvEuro.setText("Inserisci un numero e non una lettera");
    	}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtEuro != null : "fx:id=\"txtEuro\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert txtDollari != null : "fx:id=\"txtDollari\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert btnDollari != null : "fx:id=\"btnDollari\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert txtConvEuro != null : "fx:id=\"txtConvEuro\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert txtConvDollari != null : "fx:id=\"txtConvDollari\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert btnEuro != null : "fx:id=\"btnEuro\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert btnSave2 != null : "fx:id=\"btnSave2\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert txtFactor1 != null : "fx:id=\"txtFactor1\" was not injected: check your FXML file 'Convertitore.fxml'.";
        assert txtFactor2 != null : "fx:id=\"txtFactor2\" was not injected: check your FXML file 'Convertitore.fxml'.";
    }

	public void setModel(Model model) {
		this.model = model;
	}
    
    
}
