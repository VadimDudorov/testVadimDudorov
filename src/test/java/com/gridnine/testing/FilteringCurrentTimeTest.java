package com.gridnine.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilteringCurrentTimeTest {
    static FilteringRules<Flight> filteringRules;

    @BeforeAll
    static void setUp() {
        filteringRules = new FilteringCurrentTime();
    }

    @Test
    void check_departure_date_before_arrival_date() {
        LocalDateTime departureDate = LocalDateTime.of(2024, 1, 1, 15,15,0);
        LocalDateTime arrivalDate = LocalDateTime.of(2024, 1, 1, 20,15,0);
        Segment segment = new Segment(departureDate, arrivalDate);
        List<Segment> segments = List.of(segment);
        Flight flight = new Flight(segments);
        List<Flight> flights = List.of(flight);
        assertTrue(filteringRules.filtering(flights).isEmpty());
    }
}