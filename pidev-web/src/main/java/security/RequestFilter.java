package security;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Claims;

@Provider
@Secure
@Priority(Priorities.AUTHENTICATION)
public class RequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// Get the HTTP Authorization header from the request (Bearer ...)
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new NotAuthorizedException("Please provide an authorization bearer!");
		}

		String token = authorizationHeader.substring("Bearer".length()).trim();
		try {
			// Validate the token
			Claims claims = Token.decode(token);
			System.out.println("User validated with the role" + claims.get("Role"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}

}
