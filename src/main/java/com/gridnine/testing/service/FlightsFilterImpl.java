package com.gridnine.testing.service;

import com.gridnine.testing.filter.Filtering;
import com.gridnine.testing.flight.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsFilterImpl implements FlightsFilter {
    private List<Flight> flights;

    public FlightsFilterImpl(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public List<Flight> filter(Filtering filtering) {
        return flights.stream().filter(f -> !filtering.checkFlight(f)).collect(Collectors.toList());
    }
}
