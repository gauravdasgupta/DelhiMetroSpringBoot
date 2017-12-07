package com.dmrc.entities;

/**
 * Created by dasguptag on 07-12-2017.
 */
public class SmartCard {
    private long id;
    private double balance;
    private Traveller traveller;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }
}
