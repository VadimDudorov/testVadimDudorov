package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FilteringRules<Flight> filteringCurrentTime = new FilteringCurrentTime();
        FilteringRules<Flight> arrivalDateBeforeDepartureDate = new ArrivalDateBeforeDepartureDate();
        FilteringRules<Flight> timeDifference = new TimeDifference();
        System.out.println(filteringCurrentTime.filtering(flights));
        System.out.println(arrivalDateBeforeDepartureDate.filtering(flights));
        System.out.println(timeDifference.filtering(flights));
    }
}