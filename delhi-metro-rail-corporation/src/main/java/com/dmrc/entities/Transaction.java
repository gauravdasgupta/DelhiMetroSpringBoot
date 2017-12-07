package com.dmrc.entities;

import com.dmrc.fareStrategy.FareStrategy;

import java.time.LocalDateTime;

/**
 * Created by dasguptag on 07-12-2017.
 */
public class Transaction {
    long id;
    SmartCard card;
    public Station source;
    public Station destination;
    int distance;
    LocalDateTime startTime;
    LocalDateTime endTime;
    double balance;
    double fare;
    FareStrategy fareStrategy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SmartCard getCard() {
        return card;
    }

    public void setCard(SmartCard card) {
        this.card = card;
    }

    public Station getSource() {
        return source;
    }

    public void setSource(Station source) {
        this.source = source;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public FareStrategy getFareStrategy() {
        return fareStrategy;
    }

    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

}
