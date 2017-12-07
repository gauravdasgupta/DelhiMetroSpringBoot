package com.dmrc.fareStrategy;

/**
 * Created by dasguptag on 07-12-2017.
 */
public class WeekdayFareStrategy implements FareStrategy{
    @Override
    public String getName() {
        return "Weekday Fare Strategy";
    }

    @Override
    public double getFarePerStation() {
        return 7;
    }
}
