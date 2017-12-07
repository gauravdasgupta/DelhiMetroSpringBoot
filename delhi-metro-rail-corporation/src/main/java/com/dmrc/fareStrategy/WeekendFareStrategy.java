package com.dmrc.fareStrategy;

/**
 * Created by dasguptag on 07-12-2017.
 */
public class WeekendFareStrategy implements FareStrategy{
    @Override
    public String getName() {
        return "Weekend Fare Strategy";
    }

    @Override
    public double getFarePerStation() {
        return 5;
    }
}
