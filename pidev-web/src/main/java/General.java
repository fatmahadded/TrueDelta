import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entities.User;
import interfaces.IUserLocalService;
import security.Token;

@RequestScoped
public class General {
	
	@Inject
	IUserLocalService service;
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response doLogin(User user) {
		System.out.println(user.getUsername());
		User us = service.login(user.getUsername(), user.getPassword());
		if(us == null)
			return Response.status(Response.Status.BAD_REQUEST).build();
		
		String token = Token.createToken("FinBeast", user.getUsername(), 0, user.getRole());
		// Returns the token to inject it into the header with "Bearer TokenString"
		return Response.ok(us).entity(token).build();	
	}
}
