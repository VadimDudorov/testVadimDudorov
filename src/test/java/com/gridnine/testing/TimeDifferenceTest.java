package com.gridnine.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeDifferenceTest {

    static FilteringRules<Flight> filteringRules;

    @BeforeAll
    static void setUp() {
        filteringRules = new TimeDifference();
    }

    @Test
    void checking_for_two_hour_difference() {
        LocalDateTime departureDateFirst = LocalDateTime.of(2024, 1, 1, 15,15,0);
        LocalDateTime arrivalDateFirst = LocalDateTime.of(2024, 1, 1, 16,15,0);
        LocalDateTime departureDateSecond = LocalDateTime.of(2024, 1, 1, 19,16,0);
        LocalDateTime arrivalDateSecond = LocalDateTime.of(2024, 1, 1, 20,15,0);
        Segment firstSegment = new Segment(departureDateFirst, arrivalDateFirst);
        Segment secondSegment = new Segment(departureDateSecond, arrivalDateSecond);
        List<Segment> segments = List.of(firstSegment, secondSegment);
        Flight flight = new Flight(segments);
        List<Flight> flights = List.of(flight);
        assertFalse(filteringRules.filtering(flights).get(0).getSegments().contains(secondSegment));
    }
}