package Transactions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Transaction;
import interfaces.ITransactionLocalService;
import Transactions.ViewModels.AddTransactionResponse;
import Transactions.ViewModels.GetTransactionResponse;
import Transactions.ViewModels.GetTransactionsResponse;
import Transactions.ViewModels.GetTransactionsResponse.SingleTransaction;
import Transactions.ViewModels.UpdateTransactionResponse;

@Path("transaction")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionController {
	@Inject
	ITransactionLocalService service;
	
	@POST
	@Path("add/{id_portfolio}")
	public Response addTransaction(@PathParam("id_portfolio") int idPortfolio, Transaction T) {
		int idTransaction = service.addTransaction(idPortfolio, T);
		AddTransactionResponse response = new AddTransactionResponse();
		response.setTransaction_ID(idTransaction);
		return Response.status(Status.OK).entity(response).build();	
	}
	
	@POST
	@Path("update")
	public Response updateTransaction(Transaction T) {
		int idTransaction = service.updateTransaction(T);
		if(idTransaction != 0) {
			UpdateTransactionResponse response = new UpdateTransactionResponse(T.getId());
			response.setMessage("Transaction was updated!");
			return Response.status(Status.OK).entity(response).build();
		}
		UpdateTransactionResponse response = new UpdateTransactionResponse(T.getId());
		response.setMessage("Update was unsuccessful!");
		return Response.status(Status.NOT_MODIFIED).entity(response).build();
	}
	
	@GET
	@Transactional
	@Path("one/{id_transaction}")
	public Response getTransaction(@PathParam("id_transaction") int id_transaction) {
		Transaction t = service.getTransaction(id_transaction);
		if(t != null) {
			GetTransactionResponse response = new GetTransactionResponse(t.getId(),t.getAmount(), "Transaction fetched successfully!");
			return Response.status(Status.FOUND).entity(response).build();
		}
		GetTransactionResponse response = new GetTransactionResponse(0, 0, "Transaction not fetched!");
		return Response.status(Status.NOT_FOUND).entity(response).build();
	}
	
	@GET
	@Path("all/{id_portfolio}")
	public Response getTransactions(@PathParam("id_portfolio") int id_portfolio) {
		List<Transaction> t = service.getPortfolioTransactions(id_portfolio);
		if(t != null && t.size()>0) {
			List<GetTransactionsResponse.SingleTransaction> transactions = new ArrayList<GetTransactionsResponse.SingleTransaction>();
			for (Transaction transaction : t) {
				GetTransactionsResponse.SingleTransaction transactionVM = new GetTransactionsResponse.SingleTransaction(transaction.getId(), transaction.getAmount());
				transactions.add(transactionVM);
			}
			GetTransactionsResponse response = new GetTransactionsResponse(transactions, "Transactions fetched successfully!");
			return Response.status(Status.FOUND).entity(response).build();
		}
		GetTransactionsResponse response = new GetTransactionsResponse(null, "Transactions not fetched!");
		return Response.status(Status.NOT_FOUND).entity(response).build();
	}
}
