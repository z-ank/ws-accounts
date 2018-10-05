package loc.zank.services.ws;

import loc.zank.services.dao.AccountDAO;

import javax.jws.WebService;

@WebService(endpointInterface = "loc.zank.services.ws.AccountsWS")
public class AccountsWSImpl implements AccountsWS {

    @Override
    public  String getAccounts() {
        return AccountDAO.getAccountMap().toString();
    }

    @Override
    public int getAccountSum(int id) {
        return AccountDAO.getAccount(id).getSum();
    }

    @Override
    public String createAccount() {
        return AccountDAO.createAccount().toString();
    }

    @Override
    public void updateAccount(int id, int sum) {
        AccountDAO.updateAccount(id, sum);
    }

    @Override
    public void removeAccount(int id) {
        AccountDAO.removeAccount(id);
    }

}
