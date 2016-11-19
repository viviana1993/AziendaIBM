package it.alfasoft.viviana.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Fattura {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_fattura;
	
	private String codiceFattura;
	private double importo;
	private Date dataEmissione;
	
	
	

	public Fattura(String codiceFattura, double importo,
			Date dataEmissione) {
	
		this.codiceFattura = codiceFattura;
		this.importo = importo;
		this.dataEmissione = dataEmissione;
	}


	public Fattura() {
		
	}

	
	public long getId_fattura() {
		return id_fattura;
	}


	public void setId_fattura(long id_fattura) {
		this.id_fattura = id_fattura;
	}


	public String getcodiceFattura() {
		return codiceFattura;
	}


	public void setcodiceFattura(String codiceFattura) {
		this.codiceFattura = codiceFattura;
	}


	public double getImporto() {
		return importo;
	}


	public void setImporto(double importo) {
		this.importo = importo;
	}


	public Date getDataEmissione() {
		return dataEmissione;
	}


	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}
	
	
}
