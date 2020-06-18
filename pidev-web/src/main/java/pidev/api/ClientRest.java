package pidev.api;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entities.Client;
import interfaces.ClientPrtServiceRemote;
import services.ClientPrtService;

@RequestScoped
@Path("/Client")
public class ClientRest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	ClientPrtService cp;

	@Path("/addClient")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public Response addClient(Client client) {
		cp.addClient(client);
		return Response.ok("added client").build();
	}
}
