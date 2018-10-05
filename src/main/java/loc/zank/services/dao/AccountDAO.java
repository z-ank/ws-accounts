package loc.zank.services.dao;

import loc.zank.services.model.Account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountDAO {

    private static Map<Integer, Account> accountMap = new ConcurrentHashMap<>();
    private static AtomicInteger idCounter = new AtomicInteger();

    public static Map<Integer, Account> getAccountMap() {
        return accountMap;
    }

    public static AtomicInteger getIdCounter() {
        return idCounter;
    }
}
