package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TimeDifference implements FilteringRules<Flight> {
    @Override
    public List<Flight> filtering(List<Flight> value) {
        List<Flight> flightList = new ArrayList<>();
        Flight flightObject;
        for (Flight flight : value) {
            List<Segment> segments = flight.getSegments();
            List<Segment> segmentsCopy = new ArrayList<>(segments);
            for (int i = 0, j = 1; i < segments.size(); i++, j++) {
                if (j >= segments.size()) {
                    break;
                }
                Segment firstSegment = segments.get(i);
                Segment secondSegment = segments.get(j);
                if (Duration.between(firstSegment.getArrivalDate(), secondSegment.getDepartureDate()).toHours() > 2) {
                    segmentsCopy.remove(secondSegment);
                }
            }
            flightObject = new Flight(segmentsCopy);
            flightList.add(flightObject);
        }
        return flightList;
    }
}
