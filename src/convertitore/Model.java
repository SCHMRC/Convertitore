package convertitore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class Model {
	
	
	private double euro = 1.15;
	private double dollaro = 0.87;
	private File nuovo;
	private File nuovoD;
	private Date data;

	private BufferedWriter writer;


	private LinkedList<String> lista;
	
	public Model() {
		this.lista = new LinkedList<>();
		this.data = new Date();
		
	};
	
    public void crea_file()throws IOException {
    		this.nuovo = new File("dati.txt");
    		this.nuovoD = new File("datiDollaro.txt");

    	}
    
   public void scrivi(String j) throws IOException{
    	
	    lista.add(j);
	    crea_file();
	    FileWriter x = new FileWriter(nuovo);
	    this.writer = new BufferedWriter(x);
	    	
	    Iterator<String> i = lista.iterator();
	    while (i.hasNext()) {
	    	String h = i.next();
	    	writer.write(data.toString()+" "+h.toString()+ "\n");
	    	}
    	writer.close();
    	
    	FileWriter q = new FileWriter(nuovoD);
 	    this.writer = new BufferedWriter(q);
 	    	
 	    Iterator<String> k = lista.iterator();
 	    while (k.hasNext()) {
 	    	String h = k.next();
 	    	writer.write(data.toString()+" "+h.toString()+ "\n");
 	    	}
     	writer.close();
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
	
	public double getEuro() {
		return this.euro;
	}
}
