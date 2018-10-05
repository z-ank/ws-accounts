package loc.zank.services.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface AccountsWS {

    @WebMethod
    String getAccounts();

    @WebMethod
    int getAccountSum(int id);

    @WebMethod
    String createAccount();

    @WebMethod
    void updateAccount(int id, int sum);

    @WebMethod
    void removeAccount(int id);

}
