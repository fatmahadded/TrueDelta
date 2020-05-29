package controllers;


import Entities.Bank;
import Entities.Feedback;
import services.FeedbackClientService;

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


@RequestScoped
@Path("feedback")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)


public class FeedbackController {

	//ejb
	@Inject
	FeedbackClientService sf;

	//insertion dans la base de donnée
	@POST
	@Path("create")

	public Response ajouterfeedback1(Feedback feedback) {
		
		sf.ajouterFeedback(feedback);
        return Response.ok().build();
		//int idfeedback = sf. ajouterFeedback(feedback);
		//return Response.ok(idfeedback).build();
	//return Response.ok(service.ajouterContract(contract)).build();
	}
	

	
	
	
	@GET
	@Path("getById")
	public Response getFeedbackById(@PathParam(value="idfeedback") int idfeedback) {
		Feedback feedback = sf.getFeedback(idfeedback);
		return Response.ok(feedback).build();
	}
	
	
}
