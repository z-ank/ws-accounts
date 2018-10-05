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

    private static Map<Integer, Account> accountMap = AccountDAO.getAccountMap();
    private static AtomicInteger idCounter = AccountDAO.getIdCounter();

    @POST
    public Response createAccount() {
        Account account = new Account(AccountsResource.idCounter.incrementAndGet());
        AccountsResource.accountMap.put(account.getId(), account);
        return Response.created(URI.create("/accounts/" + account.getId())).build();
    }

    @GET
    @Produces("application/json")
    public Map<Integer, Account> getAccounts() {
        return AccountsResource.accountMap;
    }

    @GET
    @Path("{id}")
    @Produces("text/plain")
    public String getAccount(@PathParam("id") int id) {
        return String.valueOf(AccountsResource.accountMap.get(id).getSum());
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    public void addSum(@PathParam("id") int id, HashMap<String, Integer> in) {
        Account account = AccountsResource.accountMap.get(id);
        account.setSum(account.getSum() + in.get("sum"));
    }

    @DELETE
    @Path("{id}")
    public void deleteAccount(@PathParam("id") int id) {
        AccountsResource.accountMap.remove(id);
    }


}
