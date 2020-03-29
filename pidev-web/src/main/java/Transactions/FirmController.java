package Transactions;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Interfaces.IFirmLocalService;

@Path("firms")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FirmController {
	
	@Inject
	IFirmLocalService service;
	
	@GET
	@Path("load")
	public Response loadFirms() {
		service.fetchFirms();
		return Response.status(Status.OK).build();
	}
}
