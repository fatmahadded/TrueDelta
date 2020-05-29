package controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entities.Client;
import services.ClientService;
@RequestScoped
@Path("client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class ClientController {

	@Inject
	ClientService cs ;
	@POST
	@Path("client")
	public Response ajouterclient1(Client c) {
		int id = cs.ajouterClient(c);
		return Response.ok(id).build();
		
	}
	@DELETE
	@Path("delete")
	public  Response removeclient1(@QueryParam(value="id") int id) {
		cs.removeClient(id);
		return Response.ok().build();
	}
	@PUT
	@Path("update")
	public Response updateClient1(Client c) {
		return Response.ok(cs.updateClient(c)).build();
	}
	@GET
	@Path("getbyid")
	public Response getClientById1(@QueryParam(value="id") int id) {
		Client clc = cs.findClientById(id);
	 return Response.ok(clc).build();
		
		
	}

}


























