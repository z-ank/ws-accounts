package loc.zank.services.ws;

import loc.zank.services.dao.AccountDAO;
import loc.zank.services.model.Account;

import javax.jws.WebService;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@WebService(endpointInterface = "loc.zank.services.ws.AccountsWS")
public class AccountsWSImpl implements AccountsWS {

    private static Map<Integer, Account> accountMap = AccountDAO.getAccountMap();
    private static AtomicInteger idCounter = AccountDAO.getIdCounter();

    @Override
    public  String getAccounts() {
        return AccountsWSImpl.accountMap.toString();
    }

    @Override
    public int getAccountSum(int id) {
        return AccountsWSImpl.accountMap.get(id).getSum();
    }

}
