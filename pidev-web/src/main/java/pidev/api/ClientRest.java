package pidev.api;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import Entities.Client;
import Entities.Portfolio;
import interfaces.ClientPrtServiceRemote;

@Path("/Client")

public class ClientRest  {

	@Inject
	ClientPrtServiceRemote cp;
	@Path("/addClient")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response addClient(Client client) {
		cp.addClient(client);
		return Response.ok("added client").build();}
}
	
	