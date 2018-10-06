package loc.zank.services.rs;

import loc.zank.services.dao.AccountDAO;
import loc.zank.services.model.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Path("/accounts")
public class AccountsResource {

    @GET
    public Response getAccounts() {
        return Response.status(Response.Status.OK)
                .entity(AccountDAO.getAccountMap().toString())
                .build();
    }

    @GET
    @Path("{id}")
    public Response getAccount(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                .entity(AccountDAO.getAccount(id))
                .build();
    }

    @POST
    public Response createAccount() {
        Account account = AccountDAO.createAccount();
        return Response.created(URI.create("/accounts/" + account.getId())).build();
    }

    @POST
    @Path("/add")
    public Response createAccount(@FormParam("id") int id, @FormParam("sum") int sum) {
        Account account = AccountDAO.createAccount(id, sum);
        return Response.status(Response.Status.CREATED)
                .entity("Account #" + id + " sum = " + sum)
                .build();
    }

    @PUT
    @Path("{id}")
    public Response addSum(@PathParam("id") int id, @FormParam("sum") int sum) {
        AccountDAO.updateAccount(id, sum);
        return Response.ok()
                .entity(AccountDAO.getAccount(id).toString())
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAccount(@PathParam("id") int id) {
        AccountDAO.removeAccount(id);
        return Response.ok().build();
    }

}
