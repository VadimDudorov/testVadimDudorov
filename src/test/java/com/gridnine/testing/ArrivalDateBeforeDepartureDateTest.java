package com.gridnine.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrivalDateBeforeDepartureDateTest {

    static FilteringRules<Flight> filteringRules;

    @BeforeAll
    static void setUp() {
        filteringRules = new ArrivalDateBeforeDepartureDate();
    }

    @Test
    void check_current_point_time() {
        LocalDateTime departureDate = LocalDateTime.of(2024, 1, 1, 16,15, 0);
        LocalDateTime arrivalDate = LocalDateTime.of(2024, 1, 1, 15,15,0);
        Segment segment = new Segment(departureDate, arrivalDate);
        List<Segment> segments = List.of(segment);
        Flight flight = new Flight(segments);
        List<Flight> flights = List.of(flight);
        assertTrue(filteringRules.filtering(flights).isEmpty());
    }
}