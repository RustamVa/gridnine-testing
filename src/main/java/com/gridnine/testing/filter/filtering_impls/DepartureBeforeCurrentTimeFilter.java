package com.gridnine.testing.filter.filtering_impls;

import com.gridnine.testing.filter.Filtering;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureBeforeCurrentTimeFilter implements Filtering {
    @Override
    public boolean checkFlight(Flight flight) {
        List<Segment> segments = flight.getSegments();
        return segments.stream().anyMatch(s -> s.getDepartureDate().isBefore(LocalDateTime.now()));
    }
}
