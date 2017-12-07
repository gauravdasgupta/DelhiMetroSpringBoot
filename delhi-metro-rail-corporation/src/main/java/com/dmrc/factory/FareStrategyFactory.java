package com.dmrc.factory;

import com.dmrc.fareStrategy.FareStrategy;
import com.dmrc.fareStrategy.WeekdayFareStrategy;
import com.dmrc.fareStrategy.WeekendFareStrategy;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * Created by dasguptag on 07-12-2017.
 */
public class FareStrategyFactory {
    private static final WeekdayFareStrategy weekdayFareStrategy = new WeekdayFareStrategy();
    private static final WeekendFareStrategy weekendFareStrategy = new WeekendFareStrategy();

    public static FareStrategy getFareStrategy(LocalDateTime localDateTime){
        if(localDateTime.getDayOfWeek()== DayOfWeek.SATURDAY || localDateTime.getDayOfWeek()==DayOfWeek.SUNDAY){
            return weekendFareStrategy;
        }
        else
            return weekdayFareStrategy;
    }
}
