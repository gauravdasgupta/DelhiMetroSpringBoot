package com.dmrc.services;

import com.dmrc.dao.CardTransactionsRepo;
import com.dmrc.entities.SmartCard;
import com.dmrc.entities.Station;
import com.dmrc.entities.Transaction;
import com.dmrc.factory.FareStrategyFactory;
import com.dmrc.fareCalculator.FareCalculator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dasguptag on 07-12-2017.
 */
public class DMRCServices {
    private ConcurrentMap<Station, AtomicInteger> stationFootFall = new ConcurrentHashMap<>();
    private CardTransactionsRepo trxRepository = new CardTransactionsRepo();
    private FareCalculator fareCalculator = new FareCalculator();

    public void swipeIn(SmartCard card, Station source, LocalDateTime dateTime) {
        if (card.getBalance() < 5.5) {
            System.out.println("Minimum balance of Rs 5.5 is required at Swipe In");
        }
        stationFootFall.putIfAbsent(source, new AtomicInteger());
        stationFootFall.get(source).incrementAndGet();
        Transaction trx = new Transaction();
        trx.setSource(source);
        trx.setCard(card);
        trx.setStartTime(dateTime);
        trxRepository.addTransientTrx(card, trx);
    }

    public void swipeOut(SmartCard card, Station destination, LocalDateTime dateTime) {
        stationFootFall.putIfAbsent(destination, new AtomicInteger());
        stationFootFall.get(destination).incrementAndGet();
        Transaction trx = trxRepository.getTransientTrx(card);
        trx.setDestination(destination);
        trx.setEndTime(dateTime);
        trx.setDistance(destination.distance(trx.source));
        trx.setFare(fareCalculator.getFare(trx.source, trx.destination, dateTime));
        if (trx.getFare() > card.getBalance()) {
            System.out.println("Insufficient balance at Swipe Out, Please recharge card and try again");
        }
        trx.setFareStrategy(FareStrategyFactory.getFareStrategy(dateTime));
        trx.setBalance(card.getBalance() - trx.getFare());
        card.setBalance(card.getBalance() - trx.getFare());
        trxRepository.addCompletedTrx(card, trx);
    }

    public int calculateFootFall(Station station) {
        return stationFootFall.getOrDefault(station, new AtomicInteger(0)).get();
    }
    public List<Transaction> cardReport(SmartCard card) {
        List<Transaction> trxs = trxRepository.getCompletedTrxs(card);
        trxs.forEach(trx -> {
            System.out.println("trx = " + trx);
        });
        return trxs;
    }
}
