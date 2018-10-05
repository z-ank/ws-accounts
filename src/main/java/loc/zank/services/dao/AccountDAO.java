package loc.zank.services.dao;

import loc.zank.services.model.Account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountDAO {

    private static Map<Integer, Account> accountMap = new ConcurrentHashMap<>();
    private static AtomicInteger idCounter = new AtomicInteger();

    public static Map<Integer, Account> getAccountMap() {
        return AccountDAO.accountMap;
    }

    public static AtomicInteger getIdCounter() {
        return AccountDAO.idCounter;
    }

    public static Account createAccount() {
        Account account = new Account(AccountDAO.idCounter.incrementAndGet());
        AccountDAO.accountMap.put(account.getId(), account);
        return account;
    }

    public static Account getAccount(int id) {
        return AccountDAO.accountMap.get(id);
    }

    public static void updateAccount(int id, int sum) {
        Account account = AccountDAO.getAccount(id);
        account.setSum(account.getSum() + sum);
    }

    public static void removeAccount(int id) {
        AccountDAO.getAccountMap().remove(id);
    }

}
