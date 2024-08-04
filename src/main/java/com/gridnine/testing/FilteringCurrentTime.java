package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilteringCurrentTime implements FilteringRules<Flight> {
    @Override
    public List<Flight> filtering(List<Flight> value) {
        List<Flight> flightList = new ArrayList<>();
        Flight flightObject;
        for (Flight flight : value) {
            List<Segment> segments = flight.getSegments().stream().
                    filter(e -> e.getDepartureDate().isAfter(LocalDateTime.now())).toList();
            if (!segments.isEmpty()) {
                flightObject = new Flight(segments);
                flightList.add(flightObject);
            }
        }
        return flightList;
    }
}
