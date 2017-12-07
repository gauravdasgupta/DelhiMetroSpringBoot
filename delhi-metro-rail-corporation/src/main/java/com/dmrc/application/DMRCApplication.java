package com.dmrc.application;

import com.dmrc.entities.SmartCard;
import com.dmrc.entities.Station;
import com.dmrc.entities.Traveller;
import com.dmrc.services.DMRCServices;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

/**
 * Created by Gaurav Dasgupta on 07-12-2017.
 */
@SpringBootApplication
public class DMRCApplication {
    public static void main(String[] args) {
        //SpringApplication.run(DMRCApplication.class, args);
        LocalDateTime localDateTime = LocalDateTime.now();

        Traveller traveller = new Traveller();
        traveller.setId(115);
        traveller.setName("Gaurav");

        SmartCard smartCard = new SmartCard();
        smartCard.setId(1);
        smartCard.setBalance(700);
        smartCard.setTraveller(traveller);

        DMRCServices dmrcServices = new DMRCServices();
        dmrcServices.swipeIn(smartCard,Station.A1,localDateTime);

        System.out.println("Footfall at Station A1--"+dmrcServices.calculateFootFall(Station.A1));
        System.out.println("Smart Card Report before swipe out"+dmrcServices.cardReport(smartCard));
        System.out.println("Footfall at Station A5--"+dmrcServices.calculateFootFall(Station.A5));
        dmrcServices.swipeOut(smartCard,Station.A5,localDateTime);
        System.out.println("Smart Card Report After Swipe Out--"+dmrcServices.cardReport(smartCard));
        System.out.println("Footfall at Station A1--"+dmrcServices.calculateFootFall(Station.A5));

    }
}
