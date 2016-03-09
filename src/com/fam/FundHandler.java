package com.fam;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.fam.data.AccountDataStore;
import com.fam.domain.AccountDetails;
/**
 * This webservice offers 3 methods
 * viewAccount - view account details by id
 * viewAllAccounts - view all accounts
 * transfer - transfer funds from account a to account b 
 * @author forum
 *
 */
@Path("transferFunds")
public class FundHandler {
	
	private HashMap<Long, AccountDetails> userAccounts = AccountDataStore.getUserAccounts();
	public FundHandler() {
		super();
	}
	 	
	/**
	 * Transfers amount from AccountFrom to AccountTo
	 * @param amount		Amount to be transferred
	 * @param accountFrom	Account from where amount is transferred
	 * @param accountTo		Account to which amount is transferred
	 * @return
	 * @throws JSONException
	 */
	@Path("transfer")
	@GET
	@Produces("text/plain")
	public Response transferFunds(@QueryParam("amount") Double amount,
								@QueryParam("from") Long accountFrom,
								@QueryParam("to") Long accountTo) throws JSONException {
		String result = null;
		
		if(!userAccounts.containsKey(accountFrom)){
			result= "Error : Account " + accountFrom + " does not exist";
			return Response.status(422).entity(result).build();
		}
		if(!userAccounts.containsKey(accountTo)){
			result= "Error : Account " + accountTo + " does not exist";
			return Response.status(422).entity(result).build();
		}
		AccountDetails userAccountFrom = userAccounts.get(accountFrom);
		Double currentBalanceFrom = userAccountFrom.getCurrentBalance();
		if(currentBalanceFrom < amount){
			result= "Error : Insufficient Funds";
			return Response.status(422).entity(result).build();
		}
		AccountDetails userAccountTo = userAccounts.get(accountTo);
		userAccountFrom.setCurrentBalance(currentBalanceFrom - amount);
		Double currentBalanceTo = userAccountTo.getCurrentBalance(); 
		userAccountTo.setCurrentBalance(currentBalanceTo+amount);
		JSONObject jsonObject = new JSONObject();
		jsonObject.append(accountFrom.toString(), userAccountFrom);
		jsonObject.append(accountTo.toString(), userAccountTo);
		result = "@Produces(\"application/json\") \n\nTransferring Amount " + amount + " from " + accountFrom + " to " + accountTo + 
				"\n\n" + "Account: " + accountFrom + " ,Name: " + userAccountFrom.getFirstName() + " " + userAccountFrom.getLastName()+ " ,Current Balance: " + userAccountFrom.getCurrentBalance() +
				"\n\n" + "Account:" + accountTo + " ,Name: " + userAccountTo.getFirstName() + " " + userAccountTo.getLastName()+" ,Current Balance: " + userAccountTo.getCurrentBalance() +
				"\n\n" + jsonObject;
		return Response.status(200).entity(result).build();
		
	}
	
	/**
	 * View Account details by Id
	 * @param accountId
	 * @return
	 * @throws JSONException
	 */
	@Path("viewAccount")
	@GET
	@Produces("text/plain")
	public Response viewAccount(@QueryParam("accountId") Long accountId) throws JSONException {
		String result ="";
		if(accountId==null || !userAccounts.containsKey(accountId)){
			result = "Invalid Account Id.";
			return Response.status(422).entity(result).build();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.append(accountId.toString(), userAccounts.get(accountId));
		result = "@Produces(\"application/json\") Output: \n\nUser Account Details: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	/**
	 * View all account details
	 * @return
	 * @throws JSONException
	 */
	@Path("viewAllAccounts")
	@GET
	@Produces("text/plain")
	public Response viewAllAccounts() throws JSONException {
		String result ="";
		JSONObject jsonObject = new JSONObject();
		for(Entry<Long,AccountDetails> entry: userAccounts.entrySet()){
			jsonObject.append(entry.getKey().toString(), entry.getValue());
		}

		result = "@Produces(\"application/json\") Output: \n\nAll Account Details: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	
}
