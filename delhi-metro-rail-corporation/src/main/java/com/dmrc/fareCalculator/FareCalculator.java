package com.dmrc.fareCalculator;

import com.dmrc.entities.Station;
import com.dmrc.factory.FareStrategyFactory;
import com.dmrc.fareStrategy.FareStrategy;

import java.time.LocalDateTime;

/**
 * Created by dasguptag on 08-12-2017.
 */
public class FareCalculator {
    public double getFare(Station source, Station destination, LocalDateTime localDateTime) {
        FareStrategy fareStrategy = FareStrategyFactory.getFareStrategy(localDateTime);
        int distance = source.distance(destination);
        double fare = distance * fareStrategy.getFarePerStation();
        return fare;
    }
}
