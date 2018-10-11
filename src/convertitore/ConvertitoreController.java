/**
 * Sample Skeleton for 'Convertitore.fxml' Controller Class
 */

package convertitore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConvertitoreController {
	
	private double euro = 1.15;
	private double dollaro = 0.87;
	private File nuovo;
	private File tmp;
	private BufferedWriter writer;
	private BufferedReader reader;
	private boolean verifica=false;

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
    
   
 
    
    public int crea_file()throws IOException {
 	
    	if (verifica!=true) {
    		this.nuovo = new File("dati.txt");		
    		verifica=true;
    		return -1;
    	}else return 0;
    }
    
    public void scrivi(String j) throws IOException{
    	
    	if (crea_file()==-1) {
    	FileWriter x = new FileWriter(nuovo);
    	this.writer = new BufferedWriter(x);
    	writer.write(j);
    	writer.close();
    	}
    	else if(crea_file()==0) {
    		
    		this.tmp = new File("tmp.txt");
    		FileWriter y = new FileWriter(tmp);
    		BufferedWriter writerTmp =new BufferedWriter(y);
    		leggi();
    		String buffer = reader.readLine();
    		while(buffer!=null) {
    			writerTmp.write(buffer+" ");
    			buffer = reader.readLine();
    		}writerTmp.append(j);
    		writerTmp.close();
    		reader.close();
    		
    		FileWriter w = new FileWriter(nuovo);
    		BufferedWriter writerw = new BufferedWriter(w);
    		
        	FileReader k = new FileReader(this.tmp);
        	BufferedReader readertmp =  new BufferedReader(k);

        	
        	String buffertmp = readertmp.readLine();
    		while(buffertmp!=null) {
    			writerw.write(buffertmp);
    			buffertmp = reader.readLine();
    		}
    		readertmp.close();
    		writerw.close();
    		writer.close();
    		
    	}
    	
    }
    

    
    public void leggi() throws FileNotFoundException {
    	FileReader x = new FileReader(nuovo);
    	this.reader =  new BufferedReader(x);	
    }
    
    

    @FXML
    void saveE(ActionEvent event) throws IOException {  	
    	setEuro(Double.parseDouble(txtFactor1.getText()));
    	scrivi(txtFactor1.getText());

    }
    
    @FXML
    void saveD(ActionEvent event) {

    }

    @FXML
    void handleDollari(ActionEvent event) {
    	try {
    	Number x = Integer.parseInt(txtEuro.getText())*euro;
    	txtConvDollari.setText(x.toString()+"$");}catch(NumberFormatException exc) {
    		txtConvDollari.setText("Inserisci un numero e non una lettera");
    	}

    }

    @FXML
    void handleEuro(ActionEvent event) {
    	try {
    	Number x = Integer.parseInt(txtDollari.getText())*dollaro;
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
    
 

	public void setEuro(double euro) {
		this.euro = euro;
	}

	public double getDollaro() {
		return dollaro;
	}

	public void setDollaro(double dollaro) {
		this.dollaro = dollaro;
	}
}
