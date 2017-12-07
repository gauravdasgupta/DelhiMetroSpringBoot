package com.dmrc.dao;

import com.dmrc.entities.SmartCard;
import com.dmrc.entities.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by dasguptag on 07-12-2017.
 */
public class CardTransactionsRepo {
    private ConcurrentMap<SmartCard, Transaction> transientTransactionStore = new ConcurrentHashMap<>();
    private ConcurrentMap<SmartCard, List<Transaction>> completedTransactionStore = new ConcurrentHashMap<>();
    public void addCompletedTrx(SmartCard card, Transaction trx){
        completedTransactionStore.putIfAbsent(card, new ArrayList<>());
        completedTransactionStore.get(card).add(trx);
    }
    public void addTransientTrx(SmartCard card, Transaction trx){
        transientTransactionStore.put(card, trx);
    }
    public Transaction getTransientTrx(SmartCard card) {
        return transientTransactionStore.remove(card);
    }
    public List<Transaction> getCompletedTrxs(SmartCard card) {
        return completedTransactionStore.getOrDefault(card, Collections.emptyList());
    }
}
