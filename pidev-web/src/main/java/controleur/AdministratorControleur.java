package controleur;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Bank;
import Entities.Bnc;
import interfaces.AdministratorServiceLocal;

@RequestScoped
@Path("admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AdministratorControleur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	AdministratorServiceLocal service;
	
	
	/*@GET
	@Path("rechercheiban/{ibn}")
	    public Response rechercheIban(@PathParam("ibn") string ibn) {
		boolean re;
		re=service.findCount(ibn);
		System.out.println("la reponse"+re);
    }*/
	

	@GET
	@Path("found/{nom_bank}/{iban}/{montant}")
	public Response getAll(@PathParam("nom_bank") String nom_bank ,
    		@PathParam("iban") String iban,
    		@PathParam("montant") Double montant) {
		
		System.out.println("nombank "+iban);
		
		Bnc bnc = service.recherche(nom_bank, iban, montant);
		System.out.println("bnc " +bnc.getIban());
		
		if(montant<=bnc.getMontant())
		{
			
			System.out.println("build");
			return Response.ok(bnc).build();
			
		}
		else {
			System.out.println("bed");
			return Response.status(Status.BAD_REQUEST).build();
		}
}
			
	
		
	
	@POST
	@Path("ajoute")
    public Response create(Bank bank){
        service.createBank(bank);
        return Response.ok().build();
    }
	
	 @DELETE
	 @Path("suppeimer/{id}")
	    public Response delete(@PathParam("id") int id) {
	        Bank getBank = service.findById(id);
	        
	        service.deleteBank(getBank);
	        
	        return Response.ok().build();
	    }
	 
	 @PUT
	    @Path("miseajour/{id}")
	    public Response update(@PathParam("id") int id, Bank bank) {
	        Bank updateBank = service.findById(id);

	        updateBank.setName(bank.getName());;
	        updateBank.setSwift(bank.getSwift());
	        updateBank.setIban(bank.getIban());
	        updateBank.setLogo(bank.getLogo());
	        service.update(updateBank);

	        return Response.ok().build();
	    }
	 @GET
	 @Path("ajoutebase")
	 public Response ajoutertobase()
	 {
		 service.importbase();
		 return Response.ok().build();
	 }

}
