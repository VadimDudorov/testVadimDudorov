package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class ArrivalDateBeforeDepartureDate implements FilteringRules<Flight>{
    @Override
    public List<Flight> filtering(List<Flight> value) {
        List<Flight> flightList = new ArrayList<>();
        Flight flightObject;
        for(Flight flight : value){
            List<Segment> segments = flight.getSegments().stream().
                    filter(e -> e.getDepartureDate().isBefore(e.getArrivalDate())).toList();
            if(!segments.isEmpty()){
                flightObject = new Flight(segments);
                flightList.add(flightObject);
            }
        }
        return flightList;
    }
}
