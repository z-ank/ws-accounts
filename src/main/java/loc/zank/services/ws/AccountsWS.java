package loc.zank.services.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AccountsWS {

    @WebMethod
    String getAccounts();

    @WebMethod
    int getAccountSum(int id);

}
