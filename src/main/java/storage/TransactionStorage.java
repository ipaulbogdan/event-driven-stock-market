package storage;

import entity.Request;
import entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionStorage {

    private List<Transaction> transactions = new ArrayList<Transaction>();

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction get(Request request) {
        for(Transaction transaction: transactions) {
            if(transaction.getRequest().equals(request)) {
                return transaction;
            }
        }
        return null;
    }
}
