package controllers;


import Entities.Choix;
import Entities.Contract;
import Entities.Type;
import services.ContractHomeService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
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
import java.text.ParseException;
import java.util.Date;


@RequestScoped
@Path("contract")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)




public class ContractController {
	
//ejb
@Inject
ContractHomeService service;

//insertion dans la base de donnée

@GET
@Path("Add")
@Produces(MediaType.APPLICATION_JSON) 
public Response addContrat() { 
Contract contract = new Contract("tunisiair",3,100,100,10,100,"test",Type.Share,Choix.Sale);
service.ajouterContract( contract);
System.out.println("Add with Success");
return Response.ok(contract).build();
}








@POST
@Path("create")

public Response ajoutercontract1(Contract contract) {
	
    int cc = service.ajouterContract(contract);
	return Response.ok(cc).build();
//return Response.ok(service.ajouterContract(contract)).build();
}

@DELETE
@Path("delete")
public Response DeleteContract(@PathParam(value="id") int id) {
		service.removeContract(id);
		return Response.ok().build();
}
	
@GET
@Path("getById")
public Response getCompteById(@PathParam(value="id") int id) {
	Contract c = service.findContractById(id);
	return Response.ok(c).build();
}


//@PUT
//@Path("update")
//public Response updateContract (Contract contract) {
	
	//return Response.ok(service.updateContract(contract)).build();
//}
	
	
	
	
	
	
	

}
