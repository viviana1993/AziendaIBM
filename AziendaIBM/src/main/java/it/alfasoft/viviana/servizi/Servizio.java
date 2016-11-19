package it.alfasoft.viviana.servizi;

import java.util.List;

import it.alfasoft.viviana.dao.FatturaDao;
import it.alfasoft.viviana.model.Fattura;

public class Servizio {
	FatturaDao fDao=new FatturaDao();
	
	//metodo per creare fattura
	public boolean aggiungiFattura(Fattura f){
		return fDao.creaFattura(f);
	}
	
	//metodo per trovare fattura con id
	public Fattura cercaFatturaId(long id){
		return fDao.trovaFatturaId(id);
	}
	
	//metodo per trovare fattura con id
		public Fattura cercaFatturaCodice(String codice){
			return fDao.trovaFatturaCodice(codice);
		}
	
	//metodo per leggere lista fatture
	public List<Fattura> leggiFatture(){
		return fDao.getTutteLeFatture();
	}
	
	//metodo per  aggiornare Fattura
		public boolean aggiornaFattura(Fattura f){
			
			Fattura fV=fDao.trovaFatturaId(f.getId_fattura());
			fV.setcodiceFattura(f.getcodiceFattura());
			fV.setDataEmissione(f.getDataEmissione());
			fV.setImporto(f.getImporto());
			
			
			return fDao.aggiornaFattura(fV);
		}
		
		//metodo per rimuovere fattura
		public boolean rimuoviFattura(Fattura f){
			return fDao.rimuoviFattura(f);
		}
		
	
	
	
}
