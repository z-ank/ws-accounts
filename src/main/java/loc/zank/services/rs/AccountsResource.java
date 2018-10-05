package loc.zank.services.rs;

import loc.zank.services.dao.AccountDAO;
import loc.zank.services.model.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/accounts")
public class AccountsResource {

    @GET
    @Produces("application/json")
    public Map<Integer, Account> getAccounts() {
        return AccountDAO.getAccountMap();
    }

    @GET
    @Path("{id}")
    @Produces("text/plain")
    public String getAccount(@PathParam("id") int id) {
        return String.valueOf(AccountDAO.getAccount(id).getSum());
    }

    @POST
    public Response createAccount() {
        Account account = AccountDAO.createAccount();
        return Response.created(URI.create("/accounts/" + account.getId())).build();
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    public Response addSum(@PathParam("id") int id, HashMap<String, Integer> in) {
        AccountDAO.updateAccount(id, in.get("sum"));
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAccount(@PathParam("id") int id) {
        AccountDAO.removeAccount(id);
        return Response.ok().build();
    }

}
