package it.alfasoft.viviana.resources;


import java.util.ArrayList;
import java.util.List;

import it.alfasoft.viviana.filtri.FiltriFatturaAnno;
import it.alfasoft.viviana.filtri.FiltriFatturaMeseAnno;
import it.alfasoft.viviana.model.Fattura;
import it.alfasoft.viviana.servizi.Servizio;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("fatture")
@Produces(MediaType.APPLICATION_JSON)
public class RisorseFattura {
	private Servizio s=new Servizio();
	
	
	
	@GET
	public List<Fattura> getAllFatture(){		
		return new ArrayList<Fattura>(s.leggiFatture());
	}
	
	
	@Path("/{codiceFattura}")
	@GET	
	public Fattura getFatturaCod(@PathParam("codiceFattura") String codiceFattura){
		return s.cercaFatturaCodice(codiceFattura);
	}
	
	@Path("/registrazione")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFattura(Fattura f){
		s.aggiungiFattura(f);

		return Response.status(Status.CREATED)
						.entity(f)
						.build();
	}
	
	@GET
	@Path("/fatturaMeseAnno")
	public String getContextParameter(@BeanParam FiltriFatturaMeseAnno ff){
		
		return ff.getAnno()+ " " + ff.getMese();
	}
	
	@GET
	@Path("/fatturaAnno")
	public int getContextParameter(@BeanParam FiltriFatturaAnno ff){
		
		return ff.getAnno();
	}
	
	
}
