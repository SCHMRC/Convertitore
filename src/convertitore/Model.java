package convertitore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Model {
	
	private double euro = 1.15;
	private double dollaro = 0.87;
	private File nuovo;
	private File tmp;
	private BufferedWriter writer;
	private BufferedReader reader;
	private boolean verifica=false;
	
	public Model() {};
	
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
