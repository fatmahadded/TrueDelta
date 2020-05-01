package Transactions;

import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Asset;
import interfaces.IFirmLocalService;
import security.Secure;

@Path("firms")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@RequestScoped
public class FirmController {
	
	@Inject
	IFirmLocalService service;
	
	@GET
	@Path("load")

	public Response loadFirms() {
		service.fetchFirms();
		return Response.status(Status.OK).build();
	}
	
	@GET
	@Path("history")
	public Response getHistory() {
		service.fetchHistory();
		return Response.status(Status.OK).build();
	}
	
	@GET
	@Path("all/{limit}")
	public Response getAllHistory(@PathParam("limit") int limit) {
		List<Asset> history = service.getHistory(limit);
		return Response.status(Status.OK).entity(history).build();
	}
	
	@GET
	@Path("return/{symbol}")
	public Response getExpectedReturn(@PathParam("symbol") String symbol) {
		Map<String, Double> expectedReturn = service.getExpectedReturnByCompany(symbol);
		return Response.status(Status.OK).entity(expectedReturn).build();
	}
	
	@GET
	@Path("estimations")
	public Response getEstimations() {
		Map<Object, Object> estimations = service.getEstimationByCompany();
		return Response.status(Status.OK).entity(estimations).build();
	}
}

