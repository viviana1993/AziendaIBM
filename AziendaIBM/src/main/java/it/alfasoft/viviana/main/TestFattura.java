package it.alfasoft.viviana.main;

import it.alfasoft.viviana.dao.FatturaDao;
import it.alfasoft.viviana.model.Fattura;
import it.alfasoft.viviana.servizi.Servizio;

import java.util.Date;
import java.util.List;

public class TestFattura {

	public static void main(String[] args) {
		
		Servizio s=new Servizio();
		Date data=new Date();
		Fattura f1=new Fattura("aaa",10.90,data);
		Fattura f2=new Fattura("bbb",10.90,data);
		Fattura f3=new Fattura("ccc",10.90,data);
		Fattura f4=new Fattura("ddd",10.90,data);
		
		
//		s.aggiungiFattura(f1);
//		s.aggiungiFattura(f2);
//		s.aggiungiFattura(f3);
//		s.aggiungiFattura(f4);
		
		
		Fattura fT=s.cercaFatturaCodice("bbb");
		System.out.println(fT.getId_fattura()+" "+fT.getcodiceFattura()+" "+fT.getImporto());
		
		List<Fattura> lista=s.leggiFatture();
		for(Fattura fx:lista){
			System.out.println(fx.getId_fattura()+" "+fx.getcodiceFattura()+" "+fx.getImporto());
		}
		Fattura fr=new Fattura("ddd",100,data);
		s.aggiornaFattura(fr);
		System.out.println(fr.getId_fattura()+" "+fr.getcodiceFattura()+" "+fr.getImporto());
		
		

	}

}
