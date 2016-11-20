package it.alfasoft.viviana.main;
import it.alfasoft.viviana.dao.FatturaDao;
import it.alfasoft.viviana.model.Fattura;
import it.alfasoft.viviana.servizi.Servizio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestFattura {

	public static void main(String[] args) {
		
		Servizio s=new Servizio();
//		Date data=new Date();
//		Fattura f1=new Fattura("aaa",10.90,data);
//		Fattura f2=new Fattura("bbb",10.90,data);
//		Fattura f3=new Fattura("ccc",10.90,data);
//		Fattura f4=new Fattura("ddd",10.90,data);
		
		
//		s.aggiungiFattura(f1);
//		s.aggiungiFattura(f2);
//		s.aggiungiFattura(f3);
//		s.aggiungiFattura(f4);
		
		
//		Fattura fT=s.cercaFatturaCodice("bbb");
//		System.out.println(fT.getId_fattura()+" "+fT.getcodiceFattura()+" "+fT.getImporto());
//		
//		List<Fattura> lista=s.leggiFatture();
//		for(Fattura fx:lista){
//			System.out.println(fx.getId_fattura()+" "+fx.getcodiceFattura()+" "+fx.getImporto());
//		}
//		Fattura fr=new Fattura("ddd",100,data);
//		s.aggiornaFattura(fr);
//		System.out.println(fr.getId_fattura()+" "+fr.getcodiceFattura()+" "+fr.getImporto());
		
		
		String nomeFile="Fattura.pdf";
		
		 String percorso  = "C:\\Users\\Viviana\\Desktop";
		 
		 String fileFinale=percorso+nomeFile;
		 
		 
		
		try {
            

          //la mia lista che mantiene i dati
            List<Fattura> fatture = s.leggiFatture();
            

          // Converto la  lista to JRBeanCollectionDataSource 
          JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(fatture,false);

          //  una mappa per mandare i parametri a Jasper 
          Map<String, Object> parameters = new HashMap<String, Object>();
        
          parameters.put("DatasetFattura", itemsJRBean);

          //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
          JasperPrint jasperPrint = JasperFillManager.fillReport("ElencoFatture.jasper", parameters, new JREmptyDataSource());

          //outputStream per creare PDF 
          OutputStream outputStream = new FileOutputStream(new File(fileFinale));
         
          
          // scrivo in un  file PDF  
        
          JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

          System.out.println("File e' stato creato");
        
          
          
      } catch (JRException ex) {
          ex.printStackTrace();
      } catch (FileNotFoundException ex) {
          ex.printStackTrace();
      }
		
		

	}

	}


